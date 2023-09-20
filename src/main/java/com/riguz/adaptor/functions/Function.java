package com.riguz.adaptor.functions;

import com.riguz.adaptor.config.MinimaxConfig;
import com.riguz.adaptor.minimax.ChatRequest;
import com.riguz.adaptor.minimax.ChatResponse;
import com.riguz.adaptor.minimax.MinimaxClient;
import com.riguz.adaptor.transformer.ChatRequestTransformer;
import com.riguz.adaptor.transformer.ChatResponseTransformer;
import io.quarkus.funqy.Funq;
import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.inject.Inject;

import java.net.URI;

public class Function {
    private final MinimaxClient minimaxClient;
    private final ChatRequestTransformer transformer;
    private final ChatResponseTransformer responseTransformer;

    @Inject
    private MinimaxConfig minimaxConfig;

    public Function() {
        this.minimaxClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create("https://api.minimax.chat"))
                .build(MinimaxClient.class);
        this.transformer = new ChatRequestTransformer();
        this.responseTransformer = new ChatResponseTransformer();
    }

    @Funq
    public Output function(Input input) {
        ChatRequest request = transformer.transform(input.getPrompt());
        System.out.println(request);
        ChatResponse response = this.minimaxClient.chat(minimaxConfig.groupId(), minimaxConfig.token(), request);
        /*
        1000，未知错误
        1001，超时
        1002，触发限流
        1004，鉴权失败
        1008，余额不足
        1013，服务内部错误
        1027，输出内容错误
        1039，触发限流
        2013，输入格式信息不正常
         */
        System.out.println(response);
        int code = response.getBaseResp().getStatusCode();
        String message = response.getBaseResp().getStatusMsg();
        if (code == 2013)
            throw new IllegalArgumentException("Minimax request invalid(2013):" + message);
        else if (code != 0)
            throw new RuntimeException("Minimax request error:" + code + " " + message);
        return responseTransformer.transform(response);
    }
}
