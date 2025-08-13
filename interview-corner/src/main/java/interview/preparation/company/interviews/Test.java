package interview.preparation.company.interviews;

import java.util.*;

public class Test {

   /* public static void main(String[] args) {
        System.out.println("\n========================================================");*/

        public static void main(String[] args) {
            TransactionProcessor processor = new TransactionProcessor();

            Account acc1 = new Account("A1", 5000);
            Account acc2 = new Account("A2", 6000);

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
                e.printStackTrace();
            }

            processor.printBalances();
        }


    static class Account {
        private String accountNumber;
        private double balance;

        public Account(String accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        public void deposit(double amount) {
            if (amount > 0)
                balance += amount;
        }

        public void withdraw(double amount) {
            if (amount > 0 && balance >= amount)
                balance -= amount;
        }

        public double getBalance() {
            return balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        //equala + hashcode on acno
    }

    static class TransactionProcessor {
        private List<Account> accounts = new ArrayList<>();

        public void addAccount(Account account) {
            accounts.add(account);
        }

        public  void transfer(String fromAcc, String toAcc, double amount) {
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

   /* public class BankSimulator {
       /* public static void main(String[] args) {
            TransactionProcessor processor = new TransactionProcessor();

            Account acc1 = new Account("A1", 5000);
            Account acc2 = new Account("A2", 6000);

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
                e.printStackTrace();
            }

            processor.printBalances();
        }*/

   // }
}
