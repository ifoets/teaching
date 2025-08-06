package interview.preparation.company.interviews.design.paypal.media.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String name;
    private Set<User> followers;
    private Set<User> followees;
    private Set<User> friends;
    private Set<String> posts;

    public User(String id, String name)
    {
        this.id = id;
        this.name = name;
        this.followers = new HashSet<>();
        this.followees = new HashSet<>();
        this.friends = new HashSet<>();
        this.posts = new HashSet<>();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
