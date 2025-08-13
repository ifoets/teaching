package interview.classical.design.customannotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CheckValidUser {
    String requiredRole() default "USER";
}