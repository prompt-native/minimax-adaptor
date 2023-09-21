package com.riguz.adaptor.transformer;

import com.riguz.adaptor.minimax.*;
import com.riguz.adaptor.prompt.Chat;
import com.riguz.adaptor.prompt.Parameter;
import com.riguz.adaptor.prompt.Role;
import io.quarkus.runtime.util.StringUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChatRequestTransformer {
    private static final Map<Role, String> ROLE_MAPPING =
            Map.of(Role.USER, "USER",
                    Role.ASSISTANT, "BOT",
                    Role.FUNCTION, "FUNCTION");

    public ChatRequest transform(Chat prompt) {
        ChatRequest request = new ChatRequest();
        request.setModel(prompt.getEngine());
        request.setStream(false);
        request.setTemperature(findParameter(prompt, "temperature")
                .map(this::convertNumber)
                .orElse(null));
        request.setTopP(findParameter(prompt, "top_p")
                .map(this::convertNumber)
                .orElse(null));
        request.setMaskSensitiveInfo(findParameter(prompt, "mask_sensitive_info")
                .map(p -> (boolean) p.getValue())
                .orElse(null));
        String botName = findParameter(prompt, "bot_setting.bot_name")
                .map(p -> (String) p.getValue())
                .filter(s -> !StringUtil.isNullOrEmpty(s))
                .orElseThrow(() -> new IllegalArgumentException("bot_setting.bot_name is missing"));
        request.setBotSetting(List.of(new BotSetting(
                botName,
                findParameter(prompt, "bot_setting.content")
                        .map(p -> (String) p.getValue())
                        .filter(s -> !StringUtil.isNullOrEmpty(s))
                        .orElseThrow(() -> new IllegalArgumentException("bot_setting.content is missing"))
        )));
        request.setMessages(prompt.getMessages() == null ? null :
                prompt.getMessages()
                        .stream()
                        .map(this::convertMessage)
                        .collect(Collectors.toList()));
        request.setSampleMessages(prompt.getExamples() == null ? null :
                prompt.getExamples()
                        .stream()
                        .map(this::convertMessage)
                        .collect(Collectors.toList()));
        request.setFunctions(prompt.getFunctions()
                .stream()
                .map(this::convertFunction)
                .collect(Collectors.toList()));
        request.setReplyConstraints(new ReplyConstraints("BOT", botName));
        return request;
    }

    private float convertNumber(Parameter parameter) {
        Object number = parameter.getValue();
        if (number == null)
            throw new IllegalArgumentException("Expected number but got null");
        if (number instanceof Float) return (float) number;
        if (number instanceof Double) return ((Double) number).floatValue();
        return Float.parseFloat(number.toString());
    }

    private Message convertMessage(com.riguz.adaptor.prompt.Message message) {
        Message result = new Message();
        result.setSenderType(ROLE_MAPPING.get(message.getRole()));
        result.setSenderName(message.getName() == null ? "user" : message.getName());
        result.setText(message.getContent());
        result.setFunctionCall(message.getFunctionCall());
        return result;
    }

    private Function convertFunction(com.riguz.adaptor.prompt.Function function) {
        Function result = new Function();
        result.setName(function.getName());
        result.setDescription(function.getDescription());
        result.setParameters(convertFunctionParameter(function));

        return result;
    }

    private FunctionParameter convertFunctionParameter(com.riguz.adaptor.prompt.Function function) {
        FunctionParameter result = new FunctionParameter();
        result.setType("object");
        result.setProperties(function.getParameters()
                .stream()
                .collect(Collectors.toMap(com.riguz.adaptor.prompt.FunctionParameter::getName,
                        p -> new Property(p.getType(), p.getDescription())
                )));
        result.setRequired(function.getParameters()
                .stream()
                .filter(com.riguz.adaptor.prompt.FunctionParameter::getRequired)
                .map(com.riguz.adaptor.prompt.FunctionParameter::getName)
                .collect(Collectors.toList()));
        return result;
    }

    private Optional<Parameter> findParameter(Chat prompt, String name) {
        return prompt.getParameters().stream()
                .filter(p -> p.getName().equals(name))
                .findAny();
    }
}
