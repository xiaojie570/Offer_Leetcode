package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _819_Most_Common_Word {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        Set set = new HashSet<>();
        for (String str : banned)
            set.add(str.toLowerCase());
        for (String str : paragraph.toLowerCase().replaceAll("[^a-zA-Z ]+","").split("([^a-zA-Z']+)'\1")) {
            if (!set.contains(str))
                map.put(str, map.getOrDefault(str, 0) + 1);
        }
        String key1 = null;
        int count = Integer.MIN_VALUE;
        for (String key : map.keySet()) {
            if (count < map.get(key)) {
                count = map.get(key);
                key1 = key;
            }
        }
        return key1;
    }
}
