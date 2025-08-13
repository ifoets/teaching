package interview.preparation.company.interviews.design.flexera.transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionProcessor {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public synchronized void transfer(String fromAcc, String toAcc, double amount) {
        Account from = null, to = null;
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(fromAcc)) from = acc;
            if (acc.getAccountNumber().equals(toAcc)) to = acc;
        }

        if (from != null && to != null) {
            from.withdraw(amount);
            to.deposit(amount);
        }
    }

    public  void printBalances() {
        for (Account acc : accounts) {
            System.out.println("Account " + acc.getAccountNumber() + ": " + acc.getBalance());
        }
    }
}
