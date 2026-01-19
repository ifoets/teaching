package interview.preparation.company.design.payment_system;

public class PaymentService {
    private final WalletRepository walletRepo;

    public PaymentService(WalletRepository walletRepo) {
        this.walletRepo = walletRepo;
    }

    public void transfer(String fromUser, String toUser, long amount) {

        Wallet from = walletRepo.getWallet(fromUser);
        Wallet to = walletRepo.getWallet(toUser);

        // Avoid deadlock → lock ordering
        Wallet first = fromUser.compareTo(toUser) < 0 ? from : to;
        Wallet second = first == from ? to : from;

        first.lock();
        second.lock();

        try {
            from.debit(amount);
            to.credit(amount);
            System.out.println("Payment successful: " + amount);
        } finally {
            second.unlock();
            first.unlock();
        }
    }
}
