package interview.classical.design.customannotation;

import java.lang.reflect.Method;

public class SecurityProcessor {
    public static void invokeIfValid(Object obj, String methodName, User currentUser, Object... args) throws Exception {
        Method method = obj.getClass().getMethod(methodName, String.class);

        if (method.isAnnotationPresent(CheckValidUser.class)) {
            CheckValidUser annotation = method.getAnnotation(CheckValidUser.class);

            if (!annotation.requiredRole().equals(currentUser.role())) {
                throw new SecurityException("Access denied for user: " + currentUser.username());
            }
        }

        method.invoke(obj, args);
    }
}