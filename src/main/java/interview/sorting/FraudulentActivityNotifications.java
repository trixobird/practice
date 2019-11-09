package interview.sorting;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class FraudulentActivityNotifications {

    private FraudulentActivityNotifications() {
    }

    static int activityNotifications(int[] expenditure, int d) {

        int count = 0;
        Expenses expenses = new Expenses(Arrays.copyOfRange(expenditure, 0, d));
        for (int i = d; i < expenditure.length; i++) {
            if (expenditure[i] >= 2 * expenses.getMedian()) {
                count++;
            }
            expenses.remove(expenditure[i - d]);
            expenses.add(expenditure[i]);
        }
        return count;
    }
}

class Expenses {
    private final Map<Integer, Long> mapCount;
    private final int size;

    Expenses(int[] list) {

        mapCount = Arrays.stream(list)
                .boxed()
                .collect(groupingBy(Function.identity(), counting()));
        size = list.length;
    }

    void add(int val) {
        mapCount.put(val, mapCount.getOrDefault(val, 0L) + 1L);
    }

    void remove(int val) {
        mapCount.put(val, mapCount.get(val) - 1);
    }

    float getMedian() {
        if (size % 2 == 1) {
            return getOddMeridian();
        } else {
            return getEvenMeridian();
        }
    }

    private float getOddMeridian() {
        int count = 0;
        for (Map.Entry<Integer, Long> entry : mapCount.entrySet()) {
            count += entry.getValue();

            if (count > size / 2) {
                return entry.getKey();
            }
        }
        throw new IllegalStateException();
    }

    private float getEvenMeridian() {
        int count = 0;
        int first = -1;
        int second;
        for (Map.Entry<Integer, Long> entry: mapCount.entrySet()) {
            count += entry.getValue();

            if (count == size / 2) {
                first = entry.getKey();
            } else if (count > size / 2) {
                if (first < 0) {
                    first = entry.getKey();
                }
                second = entry.getKey();

                return (first + second) / 2f;
            }
        }
        throw new IllegalStateException();
    }
}
