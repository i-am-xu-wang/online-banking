package betterbanking.web;

import betterbanking.entity.Transaction;
import betterbanking.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/transactions",
    produces = "application/json")
@CrossOrigin(origins = "*")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(final TransactionService transactionService){
        this.transactionService= transactionService;
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<Transaction>> transactionsByAccountNumber(
        @PathVariable("accountNumber") final Integer accountNumber) {
        List<Transaction> transactions =
            transactionService.findAllByAccountNumber(accountNumber);
        if (!transactions.isEmpty()) {
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
