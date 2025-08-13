package interview.preparation.company.interviews.design.paypal.media.platform;

import java.util.Map;
import java.util.Set;

public interface IMediaPlatformAPI {

    void registerUser(String id ,String name);

    void addFriend(String from, String to);

    void removeFriend(String from, String to);

    void addFollower(String from, String to);

    void removeFollower(String from, String to);

    void post(String from, String post);

    Map<String, Set<String>> getPosts(String id);
}
