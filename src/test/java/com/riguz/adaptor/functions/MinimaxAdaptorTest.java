package com.riguz.adaptor.functions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.riguz.adaptor.minimax.ChatResponse;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class MinimaxAdaptorTest {

    @Inject
    ObjectMapper objectMapper;

    @Test
    void testDeserializeMinimaxErrorResponse() throws JsonProcessingException {
        ChatResponse response = objectMapper.readValue("{\"base_resp\":{\"status_code\":1004,\"status_msg\":\"login fail\"}}", ChatResponse.class);
        assertEquals(1004, response.getBaseResp().getStatusCode());
    }

    @Test
    void testDeserializeMinimaxNormalResponse() throws JsonProcessingException {
        ChatResponse response = objectMapper.readValue("{\"created\":1695176892,\"model\":\"abab5.5-chat\",\"reply\":\"Who am I?\",\"choices\":[{\"finish_reason\":\"stop\",\"messages\":[{\"sender_type\":\"BOT\",\"sender_name\":\"MM智能助理\",\"text\":\"Who am I?\"}]}],\"usage\":{\"total_tokens\":159},\"input_sensitive\":false,\"output_sensitive\":false,\"id\":\"01598bbbeabf180700e089b7ee15fd0a\",\"base_resp\":{\"status_code\":0,\"status_msg\":\"\"}}", ChatResponse.class);
        assertEquals(0, response.getBaseResp().getStatusCode());
        assertEquals("", response.getBaseResp().getStatusMsg());
        assertEquals("01598bbbeabf180700e089b7ee15fd0a", response.getId());
        assertEquals("Who am I?", response.getReply());
        assertEquals(1, response.getChoices().size());
        assertEquals("stop", response.getChoices().get(0).getFinishReason());
        assertEquals("Who am I?", response.getChoices().get(0).getMessages().get(0).getText());
        assertEquals(159, response.getUsage().getTotalTokens());

    }

    @Test
    public void testFunctionIntegration() {
        RestAssured.given().contentType("application/json")
                .body("{\"message\": \"Hello\"}")
                .header("ce-id", "42")
                .header("ce-specversion", "1.0")
                .post("/")
                .then().statusCode(200);
    }

}
