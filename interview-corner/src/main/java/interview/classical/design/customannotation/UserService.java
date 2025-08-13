package interview.classical.design.customannotation;

public class UserService {

    @CheckValidUser(requiredRole = "ADMIN")
    public void deleteUser(String username) {
        System.out.println(username + " deleted successfully!");
    }
}
