package interview.preparation.benchresources.java8;

import java.util.HashMap;
import java.util.Map;

public class ResourceUtils {

    public static Map<String,Integer> getMncData()
    {
        Map<String, Integer> mnc = new HashMap<>();

        // 1.1 adding key-value pairs to HashMap object
        mnc.put("HCL", 3);
        mnc.put("LTI", 7);
        mnc.put("Cogni", 6);
        mnc.put("TCS", 1);
        mnc.put("TechM", 5);
        mnc.put("Infy", 2);
        mnc.put("Wipro", 4);
        return mnc;
    }
}
