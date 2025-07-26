package interview.advance;

import org.junit.Assert;
import org.junit.Test;

public class MyTreeHashMapTest {

    @Test
    public void testCustomTreeMap()
    {
        MyTreeHashMap<String, Integer> map = new MyTreeHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);
        map.put("date", 4); // Should trigger resize after some entries
        map.put("elderberry", 5);
        map.printMap(map);
        System.out.println();
        Assert.assertEquals(5,map.size());
        System.out.println("banana: " + map.get("banana")); // 2
        map.remove("banana");
        System.out.println("banana: " + map.get("banana")); // null
        System.out.println("Size: " + map.size()); // 4
        Assert.assertEquals(4,map.size());
        System.out.println();
        map.printMap(map);
    }
}
