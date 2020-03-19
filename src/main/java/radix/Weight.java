package radix;

import java.util.*;
import java.util.stream.Collectors;

/**
 * You are provided a string containing a list of positive integers separated by a space (" "). Take each value and
 * calculate the sum of its digits, which we call it's "weight". Then return the list in ascending order by weight, as a string joined by a space.
 * <p>
 * For example 99 will have "weight" 18, 100 will have "weight"
 * 1 so in the ouput 100 will come before 99.
 * <p>
 * Example:
 * "56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes:
 * "100 180 90 56 65 74 68 86 99"
 * <p>
 * When two numbers have the same "weight", let's consider them to be strings and not numbers:
 * 100 is before 180 because its "weight" (1) is less than the one of 180 (9)
 * and 180 is before 90 since, having the same "weight" (9) it comes before as a string.
 * <p>
 * All numbers in the list are positive integers and the list can be empty.
 */
public class Weight {

    private Weight() {}

    public static String orderWeight(String strng) {
        Map<Integer, List<String>> map = new TreeMap<>();

        Arrays.stream(strng.split(" ")).forEach(str -> {
            int sum = str.chars().map(ch -> Integer.parseInt(String.valueOf((char) ch))).sum();
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(str);
        });

        return map
                .values()
                .stream()
                .map(a -> {
                    Collections.sort(a);
                    return String.join(" ", a);
                })
                .collect(Collectors.joining(" "));
    }
}
