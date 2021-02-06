package interview.dictionarieshashmaps;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class TwoStrings {

    private TwoStrings() {
    }

    static String twoStrings(String s1, String s2) {

        Map<Integer, List<Integer>> s1Map = s1
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity()));

        return s2.chars().anyMatch(s1Map::containsKey)
                ? "YES"
                : "NO";
    }
}
