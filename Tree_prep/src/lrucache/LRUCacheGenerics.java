package lrucache;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LRUCacheGenerics<K, V> {
    private Map<K, LRUCacheObject<V>> cache = new HashMap<K, LRUCacheObject<V>>();
    private static final int MAX_SIZE = 10;
    
    public void put(K key, V v) {
        // Wrapper
        LRUCacheObject<V> wrapperObj = new LRUCacheObject<V>(v);
        // cache is full, find the LRU object and replace it
        if (cache.size() == MAX_SIZE) {
            K foundKey = findLRUCacheObjKey();
            cache.remove(foundKey);
            cache.put(key, wrapperObj);
        } else {
        // otherwise, put it in
            cache.put(key, wrapperObj);
        }
            
    }
    
    private K findLRUCacheObjKey() {
        Set<Entry<K,LRUCacheObject<V>>> entries = cache.entrySet();
        Date earliest = new Date();
        K key = null;
        for (Iterator<Entry<K,LRUCacheObject<V>>> iterator = entries.iterator(); iterator.hasNext();) {
            Entry<K, LRUCacheObject<V>> entry = (Entry<K, LRUCacheObject<V>>) iterator.next();
            K tKey = entry.getKey();
            LRUCacheObject<V> temp = entry.getValue();
            if (temp.modTime.before(earliest)) {
                earliest = temp.modTime;
                key = tKey;
            }
        }
        return key;
    }

    public V get(K key) {
        //if exists, return V from the cache, modify the time
        LRUCacheObject<V> wrapperObj = cache.get(key);
        
        if (wrapperObj != null) {
            wrapperObj.resetTime();
            return wrapperObj.cacheObj;
        }
        
        // else if return null;
        return null;
    }
    
    private class LRUCacheObject<V> {
        Date modTime;
        V cacheObj;
        
        public LRUCacheObject(V obj) {
            this.cacheObj = obj;
            this.modTime = new Date();
        }
        
        public void resetTime() {
            this.modTime = new Date();
        }
        
    }
}
