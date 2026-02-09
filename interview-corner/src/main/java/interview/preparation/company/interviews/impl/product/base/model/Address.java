package interview.preparation.company.interviews.impl.product.base.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Address {
    String line1;
    String line2;
    String city;
    String country;
    String pinCode;

    public Address(String city) {
        this.city = city;
    }
}
