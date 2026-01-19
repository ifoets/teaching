package interview.preparation.company.design.payment_system;

public class PaymentSystemDemo {
    public static void main(String[] args) throws InterruptedException {

        WalletRepository repo = new WalletRepository();
        repo.createWallet("A", 1000);
        repo.createWallet("B", 1000);

        PaymentService paymentService = new PaymentService(repo);

        Runnable task = () -> paymentService.transfer("A", "B", 100);

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start(); t2.start(); t3.start();
        t1.join(); t2.join(); t3.join();

        System.out.println("Final A balance: " + repo.getWallet("A").getBalance());
        System.out.println("Final B balance: " + repo.getWallet("B").getBalance());
    }
}
