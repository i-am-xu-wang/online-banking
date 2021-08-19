package betterbanking.repository;

import betterbanking.entity.Transaction;
import betterbanking.integration.OBTransactionAdapter;
import model.OBReadTransaction6;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.Base64Utils;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Repository
public class RESTTransactionsAPIClient implements TransactionApiClient{
    private final OBTransactionAdapter adapter = new OBTransactionAdapter();
    private final WebClient webClient;

    @Value("${testnet.integration.client}")
    private String clientId;
    @Value("${testnet.integration.secret}")
    private String secret;

    @Autowired
    public RESTTransactionsAPIClient(final WebClient webClient) {
        this.webClient = webClient;
    }


    @Override public List<Transaction> findAllByAccountNumber(
        Integer accountNumber) {
        OBReadTransaction6 res = null;
        String clientEncodedData = Base64Utils.encodeToString(String.format("%s:%s", clientId,secret).getBytes());
        try {
            res = webClient.post()
                .uri("oauth/token")
                .header("Authorization", "Basic " + clientEncodedData)
                .BodyInserters.fromFormData("grant_type", "client_credentials")
                .retrieve()
                .bodyToMono(JsonNode.class)
                .flatMap(tokenResponse -> {
                    String accessTokenValue = tokenResponse.get("access_token")
                        .textValue();
                    return webClient.get()
                        .uri("accounts/" + accountNumber + "/transactions")
                        .headers(h -> h.setBearerAuth(accessTokenValue))
                        .retrieve()
                        .bodyToMono(OBReadTransaction6.class);
                })
                .block();
            ;
        } catch (Exception ex) {
            log.error("failed to retrieve account information due to the following reason {}", ex.getMessage());
        }

        if (res == null || res.getData() == null) {
            return Collections.emptyList();
        }

        return res.getData()
            .getTransaction()
            .stream()
            .map(adapter::adapt)
            .collect(toList());
    }
}
