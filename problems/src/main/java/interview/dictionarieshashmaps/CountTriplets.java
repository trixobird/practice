package interview.dictionarieshashmaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CountTriplets {

    private CountTriplets() {
    }

    /**
     * @see <a href="https://www.hackerrank.com/muthangyamusyoka">muthangyamusyoka</a>
     */
    static long countTriplets(List<Long> arr, long r) {

        Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        long count = 0;
        for (long a : arr) {
            long key = a / r;

            if (counter.containsKey(key) && a % r == 0) {
                count += counter.get(key);
            }

            if (potential.containsKey(key) && a % r == 0) {
                long c = potential.get(key);
                counter.put(a, counter.getOrDefault(a, 0L) + c);
            }

            potential.put(a, potential.getOrDefault(a, 0L) + 1); // Every number can be the start of a triplet.
        }
        return count;
    }
}
