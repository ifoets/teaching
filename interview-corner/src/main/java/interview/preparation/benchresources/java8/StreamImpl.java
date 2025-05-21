package interview.preparation.benchresources.java8;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamImpl implements IStream {
/***Java 8 Comparator – Map Sorting***/

    /**
     * Java 8 – How to Sort HashMap Key-Value pairs by its Key in ascending & descending order
     **/

    public Map<String, Integer> sortMapByKeysInAscending(Map<String,Integer> map) {

        return
            map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1,e2)->e2,
                    LinkedHashMap::new
                ));
    }

    public Map<String, Integer> sortMapByKeysInDescending(Map<String,Integer> map) {

        return
            map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1,e2)->e1,
                    LinkedHashMap::new
                ));
    }

/** Java 8 – How to Sort HashMap Key-Value pairs by its Value in ascending & descending order**/
public Map<String,Integer> sortMapByKeysThenByValue(Map<String,Integer> map){
    return
        map.entrySet()
            .stream()
            .sorted(Comparator.
                comparing(Map.Entry<String,Integer>::getValue).
                thenComparing(Map.Entry::getValue))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1,e2)->e1,
               LinkedHashMap::new
            ));
}
  public  Map<String,Integer> sortMapByValuesThenByKey(Map<String,Integer> map){
    return
        map.
            entrySet()
            .stream()
            .sorted(Comparator.
                comparing(Map.Entry<String,Integer>::getValue)
                .thenComparing(Map.Entry::getKey)
            )
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1,e2)->e1,
                    LinkedHashMap::new
                ));
  }

    public Map<String,Integer> sortMapByKeysAscThenByValueDesc(Map<String,Integer> map){
        return
            map.
                entrySet()
                .stream()
                .sorted(
                    Map.Entry.<String,Integer>comparingByKey()
                        .thenComparing(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                )
                .collect(
                    Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2)->e1,
                        LinkedHashMap::new
                    ));
    }
    public Map<String,Integer> sortMapByValuesDescThenByKeyAsc (Map<String,Integer> map){
        return
            map.
                entrySet()
                .stream()
                .sorted(
                    Map.Entry.<String,Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey())
                )
                .collect(
                    Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2)->e1,
                        LinkedHashMap::new
                    ));
    }

}
