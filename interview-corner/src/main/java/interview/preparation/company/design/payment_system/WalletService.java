package interview.preparation.company.design.payment_system;

public class WalletService {
    private final WalletRepository walletRepo;

    public WalletService(WalletRepository walletRepo) {
        this.walletRepo = walletRepo;
    }

    public void addMoney(String userId, long amount) {
        Wallet wallet = walletRepo.getWallet(userId);
        wallet.lock();
        try {
            wallet.credit(amount);
        } finally {
            wallet.unlock();
        }
    }

    public void withdrawMoney(String userId, long amount) {
        Wallet wallet = walletRepo.getWallet(userId);
        wallet.lock();
        try {
            wallet.debit(amount);
        } finally {
            wallet.unlock();
        }
    }
}
