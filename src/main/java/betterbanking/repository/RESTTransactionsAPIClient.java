package betterbanking.repository;

import betterbanking.entity.Transaction;
import betterbanking.integration.OBTransactionAdapter;
import lombok.extern.slf4j.Slf4j;
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
        return null;
    }
}
