package com.riguz.adaptor.transformer;

import com.riguz.adaptor.functions.Output;
import com.riguz.adaptor.minimax.ChatResponse;
import com.riguz.adaptor.prompt.Choice;
import com.riguz.adaptor.prompt.Message;
import com.riguz.adaptor.prompt.Role;
import com.riguz.adaptor.prompt.Usage;

import java.util.Map;
import java.util.stream.Collectors;

public class ChatResponseTransformer {
    private static final Map<String, Role> ROLE_MAPPING =
            Map.of("USER", Role.USER,
                    "BOT", Role.ASSISTANT,
                    "FUNCTION", Role.FUNCTION);

    public Output transform(ChatResponse response) {
        Output output = new Output();
        output.setExternalId(response.getId());
        if (response.getUsage() != null)
            output.setUsage(new Usage(response.getUsage().getTotalTokens(), -1, -1));
        if (response.getChoices() != null)
            output.setChoices(response.getChoices()
                    .stream()
                    .map(choice -> new Choice(choice.getFinishReason(),
                            choice.getMessages()
                                    .stream()
                                    .map(this::convertMessage)
                                    .findFirst()
                                    .orElse(null)))
                    .collect(Collectors.toList()));
        return output;
    }

    private Message convertMessage(com.riguz.adaptor.minimax.Message message) {
        Message result = new Message();
        result.setRole(ROLE_MAPPING.get(message.getSenderType()));
        result.setName(message.getSenderName());
        result.setContent(message.getText());
        result.setFunctionCall(message.getFunctionCall());
        return result;
    }
}
