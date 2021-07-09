package betterbanking;

import static org.junit.jupiter.api.Assertions.assertTrue;

import betterbanking.service.TransactionService;
import org.junit.jupiter.api.Test;

public class TransactionServiceTest {
    TransactionService transactionService = new TransactionService();

    @Test
    public void testTransactionListSize(){
        assertTrue(transactionService.findAllByAccountNumber(12345678).size() > 0);
    }

}
