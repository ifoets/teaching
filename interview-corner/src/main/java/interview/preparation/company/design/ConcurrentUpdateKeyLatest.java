package interview.preparation.company.design;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentUpdateKeyLatest {

    ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public void update(String key, int value) {
        map.compute(key, (k, oldVal) ->
            oldVal == null ? value : Math.max(oldVal, value)
        );
    }

    public Integer getLatestVal(int key)
    {
        return map.get(key);
    }
}
