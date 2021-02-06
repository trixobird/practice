package interview.warmup;

import java.util.List;

import static java.util.stream.Collectors.toList;

class CountingValleys {

    private CountingValleys() {
    }

    static int countingValleys(int n, String s) {

        int valleys = 0;

        List<Integer> steps = s
                .chars()
                .mapToObj(e -> e == 'D' ? -1 : 1)
                .collect(toList());

        for (int i = 1; i < steps.size(); i++) {
            steps.set(i, steps.get(i) + steps.get(i - 1));
            if (steps.get(i) == 0 && steps.get(i - 1) == -1) {
                valleys++;
            }
        }

        return valleys;
    }
}
