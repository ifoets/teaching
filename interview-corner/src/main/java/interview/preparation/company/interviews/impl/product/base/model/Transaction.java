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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


