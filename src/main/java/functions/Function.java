package functions;

import com.riguz.adaptor.config.MinimaxConfig;
import com.riguz.adaptor.minimax.ChatRequest;
import com.riguz.adaptor.minimax.ChatResponse;
import com.riguz.adaptor.minimax.MinimaxClient;
import io.quarkus.funqy.Funq;
import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.inject.Inject;

import java.net.URI;

public class Function {
    private final MinimaxClient minimaxClient;

    @Inject
    private MinimaxConfig minimaxConfig;

    public Function() {
        this.minimaxClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create("https://api.minimax.chat"))
                .build(MinimaxClient.class);
    }

    @Funq
    public Output function(Input input) {
        System.out.println(input);
        ChatResponse response = this.minimaxClient.chat(minimaxConfig.groupId(), minimaxConfig.token(), new ChatRequest());
        System.out.println(response);
        return new Output();
    }

}
