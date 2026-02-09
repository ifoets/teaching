package interview.preparation.company.interviews.impl.product.base;

import interview.preparation.company.interviews.model.SearchCriteria;
import interview.preparation.company.interviews.model.SearchFilter;
import interview.preparation.company.interviews.question.product.base.IAmericanExpress;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AmericanExpressImpl implements IAmericanExpress {

    @Override
    public List<String> logSearch(List<String> logs, SearchCriteria param, SearchFilter filter) {
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

        switch (filter)
        {
            case DATE_RANGE ->
            {
                return
                    logs.stream().filter(s-> {
                        try {
                             Date startDate = format.parse(param.getFromDate());
                             Date endDate = format.parse(param.getToDate());
                             Date curDate = format.parse(s.split(" ")[SearchFilter.DATE_RANGE.ordinal()]);
                             return curDate.compareTo(startDate)>=0 && curDate.compareTo(endDate)<=0;
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }).toList();
            }
            case AMOUNT ->
            {
                return logs.stream().filter(s->s.split(" ")[SearchFilter.AMOUNT.ordinal()].equals(String.valueOf(param.getAmount()))).toList();
            }
            case VENDOR ->
            {
                return logs.stream().filter(s->s.split(" ")[SearchFilter.VENDOR.ordinal()].equals(param.getVendor())).toList();
            }

            case CATEGORY ->
            {
                 return logs.stream().filter(s->s.split(" ")[SearchFilter.CATEGORY.ordinal()].equals("("+param.getCategory()+")")).toList();
            }

            case VENDORE_CATEGORY ->
            {
                return logs.stream().filter(s->
                        s.split(" ")[SearchFilter.VENDOR.ordinal()].equals(param.getVendor())
                                  &&
                                  s.split(" ")[SearchFilter.CATEGORY.ordinal()].equals("("+param.getCategory()+")")
                    ).toList();
            }
        }
        return List.of();
    }

    @Override
    public List<String> logComboSearch(List<String> logs, SearchCriteria param, SearchFilter filter) {
        Map<SearchFilter,Map<String, List<String>>> map = new HashMap<>();

        for (String log : logs) {
            String[] split = log.split("\\s");
            map.computeIfAbsent(SearchFilter.DATE_RANGE,x-> new HashMap<>()).computeIfAbsent(split[0], k -> new ArrayList<>()).add(log);
            map.computeIfAbsent(SearchFilter.AMOUNT,x-> new HashMap<>()).computeIfAbsent(split[1], k -> new ArrayList<>()).add(log);
            map.computeIfAbsent(SearchFilter.VENDOR,x-> new HashMap<>()).computeIfAbsent(split[2], k -> new ArrayList<>()).add(log);
            map.computeIfAbsent(SearchFilter.CATEGORY,x-> new HashMap<>()).computeIfAbsent(split[3], k -> new ArrayList<>()).add(log);
            map.computeIfAbsent(SearchFilter.VENDORE_CATEGORY,x-> new HashMap<>()).computeIfAbsent(split[2]+" "+split[3], k -> new ArrayList<>()).add(log);
        }
        /*TreeMap<String,List<String>> treeMap = new TreeMap<>();
        for(String date=start;date<enddate;date++)*/
        int value = filter.ordinal();
       if(value==0)//ie date rang
       {
           SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
           return
               logs.stream().filter(s-> {
                   try {
                       Date startDate = format.parse(param.getFromDate());
                       Date endDate = format.parse(param.getToDate());
                       Date curDate = format.parse(s.split(" ")[SearchFilter.DATE_RANGE.ordinal()]);
                       return curDate.compareTo(startDate)>=0 && curDate.compareTo(endDate)<=0;
                   } catch (ParseException e) {
                       throw new RuntimeException(e);
                   }
               }).toList();
       }
       else if(value==1) return map.get(filter).get(param.getAmount());
       else if(value==2) return map.get(filter).get(param.getVendor());
       else if(value==3) return map.get(filter).get("("+param.getCategory()+")");
        else if(value==4) return map.get(filter).get(param.getVendor()+" ("+param.getCategory()+")");
       return logs;
    }
}
