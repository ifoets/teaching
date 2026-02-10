package interview.preparation.company.interviews.design.american.express.model;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Generated
public class SearchData {
    private String startDate;
    private String endDate;
    private String amount;
    private String vendore;
    private String category;
    private String vendoreAndCategory;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getVendore() {
        return vendore;
    }

    public void setVendore(String vendore) {
        this.vendore = vendore;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVendoreAndCategory() {
        return vendoreAndCategory;
    }

    public void setVendoreAndCategory(String vendoreAndCategory) {
        this.vendoreAndCategory = vendoreAndCategory;
    }
}
