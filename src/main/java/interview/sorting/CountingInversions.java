package interview.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CountingInversions {

    private CountingInversions() {
    }

    static long countInversions(int[] arr) {

        Map<Integer, List<Integer>> mapValIdx = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            mapValIdx.computeIfAbsent(arr[i], v -> new ArrayList<>())
                    .add(i);
        }

        int count = 0;
        int swap = 0;
        for (Map.Entry<Integer, List<Integer>> entry : mapValIdx.entrySet()) {
            for (int val : entry.getValue()) {
                if (val > count) {
                    swap += val - count;
                }
                count++;
                mapValIdx.values().forEach(v -> {
                    for (int i = 0; i < v.size(); i++) {
                        if (v.get(i) < val) {
                            v.set(i, v.get(i) + 1);
                        }
                    }
                });
            }
        }
        return swap;
    }
}
