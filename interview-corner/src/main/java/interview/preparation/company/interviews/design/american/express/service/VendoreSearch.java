package interview.preparation.company.interviews.design.american.express.service;

import interview.preparation.company.interviews.design.american.express.amexapi.SearchData;
import interview.preparation.company.interviews.design.american.express.record.Transaction;

import java.util.List;

public class VendoreSearch implements ISearchService{
    @Override
    public List<String> search(List<Transaction> logList, SearchData data) {
        return logList.stream().filter(t-> t.vendore().equals(data.getVendore()))
            .map(Transaction::logStr).distinct().toList();
    }
}
