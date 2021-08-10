package betterbanking.service;

import betterbanking.entity.Transaction;
import betterbanking.repository.MerchantDetailsRepository;
import betterbanking.repository.TransactionApiClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionApiClient transactionApiClient;
    private final MerchantDetailsRepository merchantDetailsRepository;


    public TransactionService(
        final TransactionApiClient transactionApiClient,
        final MerchantDetailsRepository merchantDetailsRepository) {
        this.transactionApiClient = transactionApiClient;
        this.merchantDetailsRepository = merchantDetailsRepository;
    }


    @CircuitBreaker(name = "transactionService", fallbackMethod = "foundNone")
    public List<Transaction> findAllByAccountNumber(final Integer accountNumber) {
        List<Transaction> transactions =
            transactionApiClient.findAllByAccountNumber(accountNumber);
        for (Transaction transaction : transactions) {
            merchantDetailsRepository
                .findMerchantLogo(transaction.getMerchantName()).ifPresent(
                transaction::setMerchantLogo);
        }
        return transactions;
    }


    private List<Transaction> foundNone(
        final Integer accountNumber,
        final Throwable throwable) {
        return Collections.emptyList();
    }
}
