package com.riguz.adaptor.minimax;

import io.quarkus.rest.client.reactive.NotBody;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.concurrent.CompletionStage;

@RegisterRestClient
@Path("/v1/text/chatcompletion_pro")
public interface MinimaxClient {

    @POST
    @ClientHeaderParam(name = "Authorization", value = "Bearer {token}")
    CompletionStage<ChatResponse> chat(@QueryParam("GroupId") String groupId,
                                       @NotBody String token,
                                       ChatRequest request);
}
