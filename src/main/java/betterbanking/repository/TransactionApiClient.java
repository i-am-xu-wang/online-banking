package betterbanking.repository;

import betterbanking.entity.Transaction;

import java.util.List;

public interface TransactionApiClient {
    List<Transaction> findAllByAccountNumber(final Integer accountNumber);
}
