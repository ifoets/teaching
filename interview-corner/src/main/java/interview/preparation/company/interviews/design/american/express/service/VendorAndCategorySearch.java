package interview.preparation.company.interviews.design.american.express.service;

import interview.preparation.company.interviews.design.american.express.model.SearchData;
import interview.preparation.company.interviews.design.american.express.record.Transaction;

import java.util.List;

public class VendorAndCategorySearch implements ISearchService{
    @Override
    public List<String> search(List<Transaction> logList, SearchData data) {
        return logList.stream().filter(t-> t.vendore().equals(data.getVendore())&&t.category().equals("("+data.getCategory()+")"))
            .map(Transaction::logStr).distinct().toList();
    }
}
