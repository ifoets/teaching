package interview.preparation.benchresources.java8;

import java.util.Map;

public interface IStream {

    /***Java 8 Comparator – Map Sorting***/

    /**Java 8 – How to Sort HashMap Key-Value pairs by its Key in ascending & descending order **/

     Map<String,Integer> sortMapByKeysInAscending(Map<String,Integer> map);
     Map<String,Integer> sortMapByKeysInDescending (Map<String,Integer> map);

/**Java 8 – How to sort LinkedHashMap entries by its Key in ascending/descending order**/
    Map<String,Integer> sortMapByKeysThenByValue(Map<String,Integer> map);
    Map<String,Integer> sortMapByValuesThenByKey (Map<String,Integer> map);

    Map<String,Integer> sortMapByKeysAscThenByValueDesc(Map<String,Integer> map);
    Map<String,Integer> sortMapByValuesDescThenByKeyAsc (Map<String,Integer> map);

}
