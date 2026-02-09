package interview.preparation.company.interviews.design.american.express.service;

import interview.preparation.company.interviews.design.american.express.amexapi.SearchData;
import interview.preparation.company.interviews.design.american.express.record.Transaction;

import java.util.List;

public interface ISearchService {

    List<String> search(List<Transaction> logList, SearchData data);
}
