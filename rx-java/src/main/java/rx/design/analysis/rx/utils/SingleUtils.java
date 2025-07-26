package rx.design.analysis.rx.utils;

import io.reactivex.rxjava3.core.Single;

import java.util.concurrent.TimeUnit;

public class SingleUtils {

    public static Single<String> checkServiceHealth() {
        return simulateRemoteService()
            .timeout(1, TimeUnit.SECONDS) // fail if takes > 1s
            .onErrorReturn(error -> {
                System.out.println("Fallback: Service unresponsive. Using cached value.");
                return "HEALTH_UNKNOWN";
            });
    }

   public static Single<String> simulateRemoteService() {
        return Single.<String>create(emitter -> {
            System.out.println("Calling remote service...");
            Thread.sleep(2000); // Simulate slow service
            emitter.onSuccess("HEALTH_OK");
        });
    }
}
