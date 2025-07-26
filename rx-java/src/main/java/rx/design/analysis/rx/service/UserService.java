package rx.design.analysis.rx.service;

import io.reactivex.rxjava3.core.Single;
import rx.design.analysis.rx.model.HttpResponse;
import rx.design.analysis.rx.record.User;


public interface UserService {
    //@GET("users/{id}")
    Single<HttpResponse<User>> getUser(/*@Path("id")*/ String userId);
}