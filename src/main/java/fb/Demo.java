package fb;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public int solution(int[] A) {
        final List<Integer> collect = Arrays.stream(A).boxed().collect(Collectors.toSet()).stream().sorted().filter(i -> i > 0).collect(Collectors.toList());

        if (collect.isEmpty()) {
            return 1;
        }

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i) != i + 1) {
                return i + 1;
            }
        }
        return collect.get(collect.size() - 1) + 1;
    }

}
