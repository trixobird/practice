package interview.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

class AlternatingCoins {

    int solution(int[] a) {
        if (a.length == 1) {
            return 0;
        }

        List<Boolean> array = Arrays.stream(a)
                .boxed()
                .map(v -> v == 1)
                .collect(toList());

        ArrayList<Boolean> oddArray = new ArrayList<>(array);
        oddArray.set(0, !oddArray.get(0));

        int countEven = 0;
        int countOdd = 1;
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i - 1).equals(array.get(i))) {
                array.set(i, !array.get(i));
                countEven++;
            }
            if (oddArray.get(i - 1).equals(oddArray.get(i))) {
                oddArray.set(i, !oddArray.get(i));
                countOdd++;
            }
        }
        return Math.min(countEven, countOdd);
    }
}
