package betterbanking;

import betterbanking.entity.Transaction;
import betterbanking.repository.InMemoryMerchantDetailsRepository;
import betterbanking.repository.RESTTransactionsAPIClient;
import betterbanking.repository.TransactionApiClient;
import betterbanking.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import betterbanking.web.TransactionController;
import model.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import java.util.Arrays;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class TransactionComponentTest {
    @LocalServerPort
    private int port;

    MockWebServer server = new MockWebServer();
    TransactionApiClient apiClient = new RESTTransactionsAPIClient(WebClient.create(server.url("/").toString()));
    TransactionService transactionService = new TransactionService(apiClient, new InMemoryMerchantDetailsRepository());

    @Test
    public void testApplicationEndToEnd() throws Exception {
        var json = new ObjectMapper().writeValueAsString(transaction());
        server.enqueue(new MockResponse()
            .setResponseCode(200)
            .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .setBody(json));

        var t = Arrays.stream(given().standaloneSetup(new TransactionController(transactionService))
            .when()
            .get(String.format("http://localhost:%s/transactions/1234567", port))
            .then()
            .extract()
            .body()
            .as(Transaction[].class))
            .findAny()
            .orElseThrow();

        assertEquals(100.0d, t.getAmount());
    }

    private OBReadTransaction6 transaction() {
        var t = new OBReadTransaction6();
        t.setData(new OBReadDataTransaction6());
        t.getData().addTransactionItem(transactions());
        return t;
    }

    private OBTransaction6 transactions() {
        var t = new OBTransaction6();
        t.setAccountId("1234567");
        t.setCreditDebitIndicator(OBCreditDebitCode1.DEBIT);
        t.setAmount(amount());
        t.setMerchantDetails(merchantDetails());
        return t;
    }

    private OBActiveOrHistoricCurrencyAndAmount9 amount() {
        var amount = new OBActiveOrHistoricCurrencyAndAmount9();
        amount.setAmount("100.00");
        amount.setCurrency("USD");
        return amount;
    }

    private OBMerchantDetails1 merchantDetails() {
        var m = new OBMerchantDetails1();
        m.setMerchantName("acme");
        m.setMerchantCategoryCode("25");
        return m;
    }
}
