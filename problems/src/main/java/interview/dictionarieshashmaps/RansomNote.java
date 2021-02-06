package interview.dictionarieshashmaps;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

class RansomNote {

    private RansomNote() {
    }

    static void checkMagazine(String[] magazine, String[] note) {

        if (checkMagazineInternal(magazine, note)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean checkMagazineInternal(String[] magazine, String[] note) {

        if (magazine.length < note.length) {
            return false;
        }

        Map<String, Long> magazineMap = Arrays
                .stream(magazine)
                .collect(Collectors.groupingBy(identity(), counting()));

        Map<String, Long> noteMap = Arrays
                .stream(note)
                .collect(Collectors.groupingBy(identity(), counting()));

        return noteMap
                .entrySet()
                .stream()
                .allMatch(e -> magazineMap.containsKey(e.getKey())
                && magazineMap.get(e.getKey()) >= (e.getValue()));
    }
}
