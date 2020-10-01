package fb;

import java.util.ArrayList;
import java.util.List;

public class ContiguousSubarrays {

    static int[] countSubarrays(int[] arr) {

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int num = 1;
            if (i != arr.length - 1) {
                for (int i1 = i + 1; i1 < arr.length; i1++) {
                    if (arr[i1] <= arr[i]) {
                        num++;
                    } else {
                        break;
                    }
                }
            }

            if (i != 0) {
                for (int i1 = i - 1; i1 >= 0; i1--) {
                    if (arr[i1] < arr[i]) {
                        num++;
                    } else {
                        break;
                    }
                }
            }
            ret.add(num);
        }
        return ret.stream().mapToInt(i -> i).toArray();
    }
}
