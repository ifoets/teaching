package interview.preparation.company.interviews.design.american.express.service;

import interview.preparation.company.interviews.design.american.express.model.SearchData;
import interview.preparation.company.interviews.design.american.express.record.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateRangeSearch implements ISearchService{
    @Override
    public List<String> search(List<Transaction> logList, SearchData data) {
        List<String> matchingTransaction = new ArrayList<>();
        String startDate = data.getStartDate();
        String endDate = data.getEndDate();
        if (startDate == null || endDate == null) {
            return matchingTransaction;
        }
        for (Transaction tr : logList) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date start = format.parse(startDate);
                Date end = format.parse(endDate);
                Date curr = format.parse(tr.date());
                if (curr.compareTo(start)>=0 && curr.compareTo(end)<=0) {
                    matchingTransaction.add(tr.logStr());
                }
            } catch (ParseException e) {
                //log failure
            }
        }
        return matchingTransaction;
    }
}
