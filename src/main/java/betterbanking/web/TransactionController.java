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
    public List<Transaction> findAllByAccountNumber(@PathVariable("accountNumber") final Integer accountNumber) {
        return transactionService.findAllByAccountNumber(accountNumber);
    }

}
