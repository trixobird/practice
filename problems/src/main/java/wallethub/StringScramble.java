package wallethub;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class StringScramble {

    private StringScramble() {
    }

    static String stringScramble(String str1, String str2) {

        Map<Integer, Long> s2Map = str2
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer, Long> s1Map = str1
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        boolean areScramble = s2Map.keySet()
                .stream()
                .allMatch(k -> s1Map.containsKey(k) && s2Map.get(k) <= s1Map.get(k));

        return areScramble ? "true" : "false";
    }
}
