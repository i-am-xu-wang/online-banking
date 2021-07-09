package betterbanking;

import betterbanking.service.TransactionService;
import betterbanking.web.TransactionController;
import org.junit.jupiter.api.Test;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

public class TransactionComponentTest {
    @Test
    public void testApplicationEndToEnd() {
        given().standaloneSetup(new TransactionController(new TransactionService()))
            .when()
            .get("/transactions/12345678")
            .then()
            .statusCode(200);
    }
}
