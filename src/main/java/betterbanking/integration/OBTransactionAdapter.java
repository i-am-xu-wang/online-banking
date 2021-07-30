package betterbanking.integration;

import betterbanking.entity.Transaction;
import model.OBTransaction6;

import java.sql.Date;

public class OBTransactionAdapter {
    public Transaction adapt(final OBTransaction6 obTransaction6) {
        Transaction transaction = new Transaction();
        transaction
            .setAccountNumber(Integer.parseInt(obTransaction6.getAccountId()));
        transaction
            .setType(obTransaction6.getCreditDebitIndicator().toString());
        transaction.setCurrency(
            obTransaction6.getCurrencyExchange().getUnitCurrency());
        double amount =
            Double.parseDouble(obTransaction6.getAmount().getAmount());
        double rate = obTransaction6.getCurrencyExchange().getExchangeRate()
            .doubleValue();
        transaction.setAmount(amount * rate);
        transaction.setMerchantName(obTransaction6.getMerchantDetails().getMerchantName());
        transaction.setDate(
            Date.from(obTransaction6.getValueDateTime().toInstant()));

        return transaction;
    }

}
