package betterbanking.integration;

import betterbanking.entity.Transaction;
import model.OBTransaction6;

import  java.util.Date;
import java.time.OffsetDateTime;

public class OBTransactionAdapter {

    public Transaction adapt(final OBTransaction6 obTransaction6) {
        Transaction transaction = new Transaction();
        transaction
            .setAccountNumber(Integer.parseInt(obTransaction6.getAccountId()));
        transaction
            .setType(obTransaction6.getCreditDebitIndicator().toString());
        transaction.setCurrency(convertCurrency(transaction,obTransaction6));
        transaction.setAmount(convertAmount(transaction,obTransaction6));
        transaction.setMerchantName(convertMerchantName(transaction,obTransaction6));
        transaction.setDate(convertTime(transaction, obTransaction6));

        return transaction;
    }
    private String convertCurrency(Transaction transaction, OBTransaction6 obTransaction6){
        String currency;
        try{
            currency = obTransaction6.getCurrencyExchange().getUnitCurrency();
        }
        catch (Exception e){
            currency = null;
        }
        transaction.setCurrency(
            currency);
        return currency;
    }
    private Double convertAmount(Transaction transaction, OBTransaction6 obTransaction6){
        double amount;

        try{
            amount = Double.parseDouble(obTransaction6.getAmount().getAmount());
        }
        catch (Exception e){
            return null;
        }

        double rate = obTransaction6.getCurrencyExchange().getExchangeRate()
            .doubleValue();
        return amount * rate;
    }
    private String convertMerchantName(Transaction transaction, OBTransaction6 obTransaction6){
        String name;
        try{
            name = obTransaction6.getMerchantDetails().getMerchantName();
        }
        catch (Exception e){
            return null;
        }
        return name;
    }

    private Date convertTime(Transaction transaction, OBTransaction6 obTransaction6){
        Date date;
        try{
            date = Date.from(obTransaction6.getValueDateTime().toInstant());

        }
        catch (Exception e){
            return null;
        }
        return date;
    }




}
