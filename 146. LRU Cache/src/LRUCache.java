import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Integer> myMap;

    public LRUCache(int capacity) {
        myMap = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry entry) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return myMap.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        myMap.put(key, value);
    }
}