package interview.sorting;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

class MarkAndToys {

    private MarkAndToys() {
    }

    static int maximumToys(int[] prices, int k) {

        List<Integer> list = Arrays.stream(prices)
                .boxed()
                .sorted()
                .collect(toList());

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i);
            if (count > k) {
                return i;
            }
        }
        throw new IllegalStateException();
    }
}
