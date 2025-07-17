package interview.advance;

import org.junit.Test;

import java.lang.reflect.Method;

public class MyClassLoaderTest {

    @Test
    public void testMyClassLoader() throws Exception {
        MyClassLoader loader = new MyClassLoader("D://nonex/teaching/interview-corner/classes");
        Class<?> clazz = loader.loadClass("interview.advance.DeepClone");

        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getMethod("myMethod");
        method.setAccessible(true);
        method.invoke(instance); //
    }
}
