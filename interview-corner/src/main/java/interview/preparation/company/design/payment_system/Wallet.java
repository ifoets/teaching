package interview.preparation.company.design.payment_system;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

@Data
public class Wallet {
    private final String userId;
    private long balance;
    private final ReentrantLock lock = new ReentrantLock();

    public Wallet(String userId, long balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

    public long getBalance() {
        return balance;
    }

    public void debit(long amount) {
        if (balance < amount)
            throw new IllegalStateException("Insufficient balance");
        balance -= amount;
    }

    public void credit(long amount) {
        balance += amount;
    }
}
