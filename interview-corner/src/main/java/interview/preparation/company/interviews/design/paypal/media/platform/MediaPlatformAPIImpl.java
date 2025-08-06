package interview.preparation.company.interviews.design.paypal.media.platform;

import interview.preparation.company.interviews.design.paypal.media.platform.platform.MediaPlatform;

import java.util.Map;
import java.util.Set;

public class MediaPlatformAPIImpl implements IMediaPlatformAPI{

    MediaPlatform mediaPlatform;

    public MediaPlatformAPIImpl()
    {
        mediaPlatform = new MediaPlatform();
    }
    public void registerUser(String id ,String name){
        mediaPlatform.registerUser(id,name);
    }

    public void addFriend(String from, String to){
        mediaPlatform.addFriend(from,to);
    }

    public void removeFriend(String from, String to){
        mediaPlatform.removeFriend(from,to);
    }

    public void addFollower(String from, String to){
        mediaPlatform.addFollower(from,to);
    }

    public void removeFollower(String from, String to){
        mediaPlatform.removeFollower(from,to);
    }

    public void post(String from, String post){
        mediaPlatform.post(from,post);
    }

    public Map<String, Set<String>> getPosts(String id){
        return mediaPlatform.getPosts(id);
    }
}
