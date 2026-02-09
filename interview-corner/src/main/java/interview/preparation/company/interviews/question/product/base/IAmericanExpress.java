package interview.preparation.company.interviews.question.product.base;

import interview.preparation.company.interviews.model.SearchCriteria;
import interview.preparation.company.interviews.model.SearchFilter;

import java.util.List;

public interface IAmericanExpress {

    List<String> logSearch(List<String> logs, SearchCriteria param, SearchFilter filter);

    List<String> logComboSearch(List<String> logs, SearchCriteria param, SearchFilter filter);
}

