package interview.classical.design.customannotation;

import org.junit.Assert;
import org.junit.Test;

public class CustomAnnotationTest {


    @Test
    public void testCustomAnnotationUserSecurityCheck() throws Exception {
        UserService service = new UserService();

        User admin = new User("John", "ADMIN");
        User normal = new User("Alice", "USER");

        // Works
        SecurityProcessor.invokeIfValid(service, "deleteUser", admin, "Mark");

        try {
            SecurityProcessor.invokeIfValid(service, "deleteUser", normal, "Mark");
        }catch (SecurityException e)
        {
            Assert.assertEquals("Access denied for user: Alice",e.getMessage());
        }
    }
}
