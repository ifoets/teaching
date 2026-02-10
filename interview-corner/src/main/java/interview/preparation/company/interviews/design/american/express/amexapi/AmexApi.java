package interview.preparation.company.interviews.design.american.express.amexapi;

import interview.preparation.company.interviews.design.american.express.model.SearchData;
import interview.preparation.company.interviews.design.american.express.record.Transaction;
import interview.preparation.company.interviews.design.american.express.service.*;

import java.util.*;

public class AmexApi {

    ISearchService iSearchService;

    List<String> searchTransactionLog(List<String> logList, SearchData data, String dataType)
    {
         return getService(dataType).search(getTransactions(logList),data);
    }

    public List<Transaction> getTransactions(List<String> logList)
    {
        List<Transaction> transactions = new ArrayList<>();
        for(String log:logList)
        {
            String[] strs=log.split("\\s");
            transactions.add(new Transaction(UUID.randomUUID(),strs[0],strs[1],strs[2],strs[3],log));
        }
        return transactions;
    }
    public ISearchService getService(String dataType)
    {
        switch (dataType)
        {
            case "DateRannge" -> {
                return new DateRangeSearch();
            }
            case "Amount" -> {
                return new AmountSearch();
            }
            case "Vendore"-> {
                return new VendoreSearch();
            }
            case "Category"->
                {
                   return new CategorySearch();
                }
            case "VendoreAndCateogry"->{
                return new VendorAndCategorySearch();
            }
        }
        return null;
    }


}
