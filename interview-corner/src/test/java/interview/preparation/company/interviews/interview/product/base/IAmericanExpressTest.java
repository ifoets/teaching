package interview.preparation.company.interviews.interview.product.base;

import interview.preparation.company.interviews.impl.product.base.AmericanExpressImpl;
import interview.preparation.company.interviews.model.SearchCriteria;
import interview.preparation.company.interviews.model.SearchFilter;
import interview.preparation.company.interviews.question.product.base.IAmericanExpress;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IAmericanExpressTest {

    IAmericanExpress ime;
    List<String> inputs;
    @Before
    public void init()
    {
        ime = new AmericanExpressImpl();
        inputs = new ArrayList<>();
        //it has date price vendor category
        inputs.add("01/01/2021 $100.44 FitnessClub (Exercise)");
        inputs.add("01/01/2023 $100.44 FitnessClub (payment)");
        inputs.add("05/07/2022 $50.25 Xerox (Instrument)");
        inputs.add("05/01/2021 $70.55 Appl1 (Food1)");
        inputs.add("09/01/2021 $70.55 Apple (Food)");
        inputs.add("05/07/2021 $50.25 Payment (Xerox)");
    }

    @Test
    public void queryRangeTest()
    {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setFromDate("01/01/2021");
        searchCriteria.setToDate("31/01/2021");
        searchCriteria.setVendor("FitnessClub");
        searchCriteria.setCategory("Exercise");
        List<String> logs = ime.logSearch(inputs,searchCriteria, SearchFilter.DATE_RANGE);
        System.out.println(logs);
        logs = ime.logSearch(inputs,searchCriteria, SearchFilter.VENDOR);
        System.out.println(logs);
        logs = ime.logSearch(inputs,searchCriteria, SearchFilter.CATEGORY);
        System.out.println(logs);
        searchCriteria.setVendor("Xerox");
        searchCriteria.setCategory("Instrument");
        logs = ime.logSearch(inputs,searchCriteria, SearchFilter.VENDORE_CATEGORY);
        System.out.println(logs);
        searchCriteria.setAmount("$50.25");
        logs = ime.logSearch(inputs,searchCriteria, SearchFilter.AMOUNT);
        System.out.println(logs);
    }

    @Test
    public void logComboSearchTest()
    {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setFromDate("01/01/2021");
        searchCriteria.setToDate("31/01/2021");
        searchCriteria.setVendor("FitnessClub");
        searchCriteria.setCategory("Exercise");
        List<String> logs = ime.logComboSearch(inputs,searchCriteria, SearchFilter.DATE_RANGE);
        System.out.println(logs);
        logs = ime.logComboSearch(inputs,searchCriteria, SearchFilter.VENDOR);
        System.out.println(logs);
        logs = ime.logComboSearch(inputs,searchCriteria, SearchFilter.CATEGORY);
        System.out.println(logs);
        searchCriteria.setVendor("Xerox");
        searchCriteria.setCategory("Instrument");
        logs = ime.logComboSearch(inputs,searchCriteria, SearchFilter.VENDORE_CATEGORY);
        System.out.println(logs);
        searchCriteria.setAmount("$50.25");
        logs = ime.logComboSearch(inputs,searchCriteria, SearchFilter.AMOUNT);
        System.out.println(logs);
    }
}
