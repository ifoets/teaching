package interview.preparation.company.interviews.design.flexera.ratelimitar;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerRateLimiter {
    private final BlockingQueue<String> tokenBucket;

    public ProducerConsumerRateLimiter(int bucketCapacity, int tokensPerSecond) {
        this.tokenBucket = new ArrayBlockingQueue<>(bucketCapacity);

        // Producer thread: Adds tokens at a fixed rate
        Thread producer = new Thread(() -> {
            try {
                while (true) {
                    tokenBucket.put("TOKEN"); // blocks if bucket is full
                    Thread.sleep(1000 / tokensPerSecond);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.setDaemon(true); // stops when main program ends
        producer.start();
    }

    // Consumer tries to acquire token
    public boolean tryConsume() {
        return tokenBucket.poll() != null;
    }
}
