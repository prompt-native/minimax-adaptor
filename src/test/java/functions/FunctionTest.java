package functions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.riguz.adaptor.minimax.ChatResponse;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class FunctionTest {

    @Inject
    ObjectMapper objectMapper;

    @Test
    void testDeserializeMinimaxResponse() throws JsonProcessingException {
        ChatResponse response = objectMapper.readValue("{\"base_resp\":{\"status_code\":1004,\"status_msg\":\"login fail\"}}", ChatResponse.class);
        assertEquals(1004, response.getBaseResp().getStatusCode());
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
