package interview.preparation.company.interviews.design.american.express.amexapi;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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

}
