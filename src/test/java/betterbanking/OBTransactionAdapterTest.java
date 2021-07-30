package betterbanking;


import betterbanking.integration.OBTransactionAdapter;
import model.OBCreditDebitCode1;
import model.OBMerchantDetails1;
import model.OBTransaction6;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OBTransactionAdapterTest {
    final OBTransactionAdapter adapter = new OBTransactionAdapter();

    @Test
    public void testNullMerchant() {
        var ob = new OBTransaction6();
        ob.setAccountId("1234567");
        ob.setCreditDebitIndicator(OBCreditDebitCode1.DEBIT);
        ob.setAmount(ob.getAmount());
        var t = adapter.adapt(ob);
        assertEquals(null, t.getMerchantName());
    }

    @Test
    public void testMerchant() {
        var ob = new OBTransaction6();
        ob.setAccountId("1234567");
        ob.setCreditDebitIndicator(OBCreditDebitCode1.DEBIT);
        ob.setAmount(ob.getAmount());
        ob.setMerchantDetails(new OBMerchantDetails1().merchantName("acme"));
        var t = adapter.adapt(ob);
        assertEquals("acme", t.getMerchantName());
    }


}
