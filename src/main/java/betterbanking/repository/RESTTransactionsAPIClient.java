package betterbanking.repository;

import betterbanking.entity.Transaction;
import betterbanking.integration.OBTransactionAdapter;
import lombok.extern.slf4j.Slf4j;
import model.OBReadTransaction6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Repository
public class RESTTransactionsAPIClient implements TransactionApiClient{
    private final OBTransactionAdapter adapter = new OBTransactionAdapter();
    private final WebClient webClient;

    @Autowired
    public RESTTransactionsAPIClient(final WebClient webClient) {
        this.webClient = webClient;
    }


    @Override public List<Transaction> findAllByAccountNumber(
        Integer accountNumber) {
        OBReadTransaction6 res = null;
        try {
            res = webClient.get()
                .uri("accounts/" + accountNumber + "/transactions")
                .retrieve()
                .bodyToMono(OBReadTransaction6.class)
                .block()
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
