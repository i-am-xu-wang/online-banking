package betterbanking.entity;
import lombok.Data;

import java.util.Date;

@Data
public class Transaction {
    private String type;
    private Date date;
    private Integer accountNumber;
    private String currency;
    private Double amount;
    private String merchantName;
    private String merchantLogo;

    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public Integer getAccountNumber() {
        return accountNumber;
    }


    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }


    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public Double getAmount() {
        return amount;
    }


    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public String getMerchantName() {
        return merchantName;
    }


    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }


    public String getMerchantLogo() {
        return merchantLogo;
    }


    public void setMerchantLogo(String merchantLogo) {
        this.merchantLogo = merchantLogo;
    }

    public Transaction(){

    }

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
