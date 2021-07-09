package betterbanking.service;

import betterbanking.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    public List<Transaction> findAllByAccountNumber(final Integer accountNumber) {
        return List.of(
            new Transaction("credit", 1234567, "USD", 100.00, "acme",
                "acme.png")
        );
    }
}
