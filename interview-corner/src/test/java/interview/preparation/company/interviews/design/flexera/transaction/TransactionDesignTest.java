package interview.preparation.company.interviews.design.flexera.transaction;

import org.junit.Test;

public class TransactionDesignTest {


    @Test
    public void testTransaction()
    {
        BankSimulator bankSimulator = new BankSimulator(new TransactionProcessor());
         Account acc1 = new Account("A1", 5000);
         Account acc2 = new Account("A2", 6000);
         bankSimulator.executeTransaction(acc1,acc2);
    }
}
