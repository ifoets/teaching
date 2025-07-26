package rx.design.analysis.rx.validation;

import io.reactivex.rxjava3.core.Completable;
import rx.design.analysis.rx.record.Employee;
import rx.design.analysis.rx.utils.CompletableUtils;

public class EmployeeValidation {
    public static Completable validateUser(Employee employee) {
        return CompletableUtils.validateEmailFormat(employee.email())
            .andThen(CompletableUtils.checkEmailNotRegistered(employee.email()))
            .andThen(CompletableUtils.validatePasswordStrength(employee.password()));
    }


}
