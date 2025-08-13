package interview.preparation.company.interviews.design.flexera.transaction;

public class BankSimulator {

    private final TransactionProcessor processor;
    public BankSimulator(TransactionProcessor transactionProcessor) {
        this.processor = transactionProcessor;
    }

    public void executeTransaction(Account acc1, Account acc2)
    {

        processor.addAccount(acc1);
        processor.addAccount(acc2);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                processor.transfer("A1", "A2", 1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                processor.transfer("A2", "A1", 1);
            }
        });

        t1.start();
        t2.start();

            try {
        t1.join();
        t2.join();
    } catch (InterruptedException e) {
                System.out.println(e.getLocalizedMessage());
    }
            processor.printBalances();
    }
}
