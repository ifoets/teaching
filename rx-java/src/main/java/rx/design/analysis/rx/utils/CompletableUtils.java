package rx.design.analysis.rx.utils;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public class CompletableUtils {
    public static Completable validateEmailFormat(String email) {
        return Completable.fromAction(() -> {
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                throw new IllegalArgumentException("Invalid email format");
            }
        });
    }

    public static Completable checkEmailNotRegistered(String email) {
        // Simulate an async db/API check
        return Single.just(email.equalsIgnoreCase("john@example.com"))
            .flatMapCompletable(isTaken -> {
                if (isTaken) {
                    return Completable.error(new IllegalArgumentException("Email already registered"));
                }
                return Completable.complete();
            });
    }

    public static Completable validatePasswordStrength(String password) {
        return Completable.fromAction(() -> {
            if (password.length() < 8 || !password.matches(".*[A-Z].*")) {
                throw new IllegalArgumentException("Weak password");
            }
        });
    }

   public static Completable saveUserToDatabase() {
        return Completable.fromRunnable(() -> {
            System.out.println("Saving user to database...");
            // simulate success
        });
    }

    public static Completable sendWelcomeEmail() {
        return Completable.fromRunnable(() -> {
            System.out.println("Sending welcome email...");
            // simulate failure
            throw new RuntimeException("Email service down");
        });
    }

    public static Completable logUserRegistration() {
        return Completable.fromRunnable(() -> {
            System.out.println("Logging user registration...");
        });
    }
}
