package interview.preparation.company.interviews.impl.product.base.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class Transaction {
    private int id;
    private BigDecimal amount;
    private String currency;
    private String status;

    public Transaction(int i, BigDecimal bigDecimal, String usd, String completed) {
        this.id=i;
        this.amount=bigDecimal;
        this.currency=usd;
        this.status=completed;
    }
}
