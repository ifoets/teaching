package rx.design.analysis.rx.service;

import io.reactivex.rxjava3.core.Single;
import rx.design.analysis.rx.model.HttpResponse;
import rx.design.analysis.rx.record.User;


public class UserServiceImpl implements UserService {

    @Override
    public Single<HttpResponse<User>> getUser(/*@Path("id")*/ String userId){
        // Suppose this is a successful response wrapper
        User user = new User("123", "John Doe");
        return Single.just(HttpResponse.success(user));
    }
}
