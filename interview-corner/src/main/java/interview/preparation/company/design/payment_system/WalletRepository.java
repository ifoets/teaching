package interview.preparation.company.design.payment_system;

import java.util.concurrent.ConcurrentHashMap;

public class WalletRepository {
    private final ConcurrentHashMap<String, Wallet> wallets = new ConcurrentHashMap<>();

    public Wallet createWallet(String userId, long initialBalance) {
        Wallet wallet = new Wallet(userId, initialBalance);
        wallets.put(userId, wallet);
        return wallet;
    }

    public Wallet getWallet(String userId) {
        return wallets.get(userId);
    }
}
