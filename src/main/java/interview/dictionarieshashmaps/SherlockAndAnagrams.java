package interview.dictionarieshashmaps;

import java.util.HashMap;
import java.util.Map;

class SherlockAndAnagrams {

    private SherlockAndAnagrams() {
    }

    static int sherlockAndAnagrams(String s) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = 0; j < s.length() - i; j++) {
                String substring = s.substring(j, j + i + 1);
                int stringHash = calcAnagramHash(substring);
                if (!countMap.containsKey(stringHash)) {
                    countMap.put(stringHash, 1);
                } else {
                    Integer integer = countMap.get(stringHash);
                    countMap.put(stringHash, integer + 1);
                }
            }
            count += countMap
                    .values()
                    .stream()
                    .filter(v -> v > 1)
                    .mapToInt(v -> triangularNumber(v - 1))
                    .sum();
        }
        return count;
    }

    private static int triangularNumber(int n) {
        return (int) ((Math.pow(n, 2) + n) / 2);
    }

    private static int hash32shift(int key)
    {
        key = ~key + (key << 15);
        key = key ^ (key >>> 12);
        key = key + (key << 2);
        key = key ^ (key >>> 4);
        key = key * 2057;
        key = key ^ (key >>> 16);
        return key;
    }

    private static int calcAnagramHash(String s) {

        return (int) s.chars().mapToLong(value -> value = hash32shift(value)).sum();
    }
}
