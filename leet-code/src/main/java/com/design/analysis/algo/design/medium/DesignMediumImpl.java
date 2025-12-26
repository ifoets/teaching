package com.design.analysis.algo.design.medium;

import java.util.Map;

public class DesignMediumImpl implements IDesignMedium{

    /**146. LRU Cache**/
    public Map<Integer,String> LRUCacheOperation(String[] command, String[] values, int[] keys){
        LRUCache<Integer,String> lruCache = new LRUCache<>(4);

        for(int i=0;i<command.length;i++)
        {
            switch (command[i]) {
                case "put" -> lruCache.put(keys[i],values[i]);
                case "get"-> System.out.println(lruCache.get(keys[i]));
                case "disp"-> System.out.println(lruCache.toString());
            }
        }
        return lruCache;
    }
}
