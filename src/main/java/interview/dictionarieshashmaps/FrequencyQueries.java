package interview.dictionarieshashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FrequencyQueries {

    private FrequencyQueries() {
    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (List<Integer> query : queries) {
            Integer element = query.get(1);
            switch (query.get(0)) {
                case 1:
                    int oldCount = counts.getOrDefault(element, 0);
                    counts.put(element, oldCount + 1);
                    updateFreq(freq, counts, element, oldCount);
                    break;
                case 2:
                    if (counts.containsKey(element)) {
                        oldCount = counts.get(element);
                        if (counts.get(element) > 0) {
                            counts.put(element, counts.get(element) - 1);
                        }
                        updateFreq(freq, counts, element, oldCount);
                    }
                    break;
                case 3:
                    result.add(freq.containsKey(element) ? 1 : 0);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + query.get(0));
            }
        }

        return result;
    }

    private static void updateFreq(HashMap<Integer, Integer> freq, HashMap<Integer, Integer> counts, Integer element, int oldCount) {
        freq.put(counts.get(element), freq.getOrDefault(counts.get(element), 0) + 1);
        if (oldCount > 0 && freq.containsKey(oldCount)) {
            if (freq.get(oldCount) == 1) {
                freq.remove(oldCount);
            } else {
                freq.put(oldCount, freq.get(oldCount) - 1);
            }
        }
    }
}
