package interview.preparation.company.interviews.design.flexera.ratelimitar;

import org.junit.Test;

public class ProducerConsumerRateLimiterTest {



    @Test
    public void rateLimiterTest() throws InterruptedException {
        ProducerConsumerRateLimiter limiter = new ProducerConsumerRateLimiter(5, 2);
        // Bucket size = 5, produce 2 tokens/sec

        for (int i = 0; i < 15; i++) {
            if (limiter.tryConsume()) {
                System.out.println(i + " Allowed at " + System.currentTimeMillis());
            } else {
                System.out.println(i + " Rejected at " + System.currentTimeMillis());
            }
            Thread.sleep(300); // 0.3 sec between requests
        }
    }
}
