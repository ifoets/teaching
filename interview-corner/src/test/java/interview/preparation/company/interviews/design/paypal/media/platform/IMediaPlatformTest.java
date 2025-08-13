package interview.preparation.company.interviews.design.paypal.media.platform;

import org.junit.Before;
import org.junit.Test;

public class IMediaPlatformTest {
    private IMediaPlatformAPI imp;

    @Before
    public void init()
    {
        imp = new MediaPlatformAPIImpl();
    }

    @Test
    public void testMediaPlatform()
    {
        imp.registerUser("5","Abhimanyu");
        imp.addFollower("1","5");
        imp.addFriend("2","5");
        imp.post("5","I am live, u can connect....");
        imp.post("2","Thanks for live....");
        imp.addFollower("3","5");
        imp.post("5","Lets, meet friends....");

        System.out.println("\n\n========================================");
        imp.removeFollower("3","5");
        imp.removeFriend("2","5");
        imp.post("5","OK guys See u again bye......");
        System.out.println("\n\n========================================");
        System.out.println(imp.getPosts("5"));
    }
}
