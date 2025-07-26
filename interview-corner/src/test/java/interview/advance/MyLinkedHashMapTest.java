package interview.advance;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedHashMapTest {

    @Test
    public void myLinkdedHashMapTest() {
        MyLinkedHashMap<String, Integer> map = new MyLinkedHashMap<>();
        map.put("apple", 100);
        map.put("banana", 200);
        map.put("apple", 150); // update
        Assert.assertEquals(2, map.size());
        System.out.println(map.get("apple"));   // 150
        System.out.println(map.get("banana"));  // 200
        Assert.assertEquals(2, map.size());
        map.remove("apple");
        System.out.println(map.get("apple"));   // null
        Assert.assertEquals(1, map.size());
    }
}
