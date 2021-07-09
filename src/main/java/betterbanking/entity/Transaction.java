package betterbanking.entity;
import lombok.Data;
@Data
public class Transaction {
    private String type;
    private Integer accountNumber;
    private String currency;
    private Double amount;
    private String merchantName;
    private String merchantLogo;


    public Transaction(
        String type,
        Integer accountNumber,
        String currency,
        Double amount,
        String merchantName,
        String merchantLogo) {
        this.type = type;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.amount = amount;
        this.merchantName = merchantName;
        this.merchantLogo = merchantLogo;
    }
}
