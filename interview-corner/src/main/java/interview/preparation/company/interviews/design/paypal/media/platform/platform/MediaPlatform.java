package interview.preparation.company.interviews.design.paypal.media.platform.platform;

import interview.preparation.company.interviews.design.paypal.media.platform.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MediaPlatform {

    static Map<String, User> platformMap = new HashMap<>();

     public MediaPlatform()
    {
        platformMap.put("1",new User("1","abhi")) ;
        platformMap.put("2",new User("2","kumar")) ;
        platformMap.put("3",new User("3","raj")) ;
        platformMap.put("4",new User("4","suman")) ;
    }

    public void registerUser(String id ,String name){
          if(!platformMap.containsKey(id))
          {
              platformMap.put(id,new User(id,name));
              liveActions(id,null,null,"REGISTERED");
          }
          else throw new RuntimeException("User with id "+id+" all ready registered");
    }

    public void addFriend(String from, String to){
         checkUsersExistence(from,to);
         platformMap.get(from).getFriends().add(new User(to,platformMap.get(to).getName()));
         platformMap.get(to).getFriends().add(new User(from,platformMap.get(from).getName()));
        liveActions(from,to,null,"ADD-FRIEND");
    }

    public void removeFriend(String from, String to){
        checkUsersExistence(from,to);
        platformMap.get(from).getFriends().remove(new User(to,platformMap.get(to).getName()));
        platformMap.get(to).getFriends().remove(new User(from,platformMap.get(from).getName()));
    }

    public void addFollower(String from, String to){
        checkUsersExistence(from,to);
        platformMap.get(from).getFollowers().add(new User(to,platformMap.get(to).getName()));
        platformMap.get(to).getFollowees().add(new User(from,platformMap.get(from).getName()));
        liveActions(from, to,null,"ADD-FOLLOWER");
    }

    public void removeFollower(String from, String to){
        checkUsersExistence(from,to);
        platformMap.get(from).getFollowers().remove(new User(to,platformMap.get(to).getName()));
        platformMap.get(to).getFollowees().remove(new User(from,platformMap.get(from).getName()));
    }

    public void post(String from, String post){
        platformMap.get(from).getPosts().add(post);
        liveActions(from, null,post,"POST");
    }

    /*Post can get from all followee and friends*/
    public Map<String, Set<String>> getPosts(String id){
        HashMap<String, Set<String>> map = new HashMap<>();
        map.put(platformMap.get(id).getName(),platformMap.get(id).getPosts());
        return map;
    }
    public void checkUsersExistence(String from, String to)
    {
        if(from!=null && !platformMap.containsKey(from))
        {
            throw new RuntimeException("User with id "+from+" not registered");
        }
        else if(to!=null&& !platformMap.containsKey(to))
        {
            throw new RuntimeException("User with id "+to+" not registered");
        }
    }

    public void liveActions(String from, String to, String post,String action)
    {
          switch (action)
          {
              case "REGISTERED" ->System.out.println("Welcome "+platformMap.get(from).getName() +" to Media Platform");
              case "ADD-FRIEND" -> System.out.println(platformMap.get(to).getName() +" accepted friend request of "+platformMap.get(from).getName());
              case "ADD-FOLLOWER" -> System.out.println(platformMap.get(from).getName() +" following to "+platformMap.get(to).getName());
              case "POST" -> {
                  System.out.println(platformMap.get(from).getName() + " posted " + post);
                  platformMap.get(from).getFriends().forEach(friend -> System.out.println(friend.getName()+" getting post "+post +" from "+platformMap.get(from).getName()));
                  platformMap.get(from).getFollowees().forEach(followers -> System.out.println(followers.getName()+" getting post "+post +" from "+platformMap.get(from).getName()));

              }

          }
    }
}
