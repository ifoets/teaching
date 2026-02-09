package interview.preparation.company.interviews.impl.product.base.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
public class Employee {

    String name;
    Integer id;
    Double salary;
    String gender;
    Date dateOfJoining;
    List<Address> addresses;

    public Employee(String name, List<Address> addresses) {
        this.name = name;
        this.addresses = addresses;
    }
}
