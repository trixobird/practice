package interview.dictionarieshashmaps;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static interview.dictionarieshashmaps.FrequencyQueries.freqQuery;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class FrequencyQueriesTest {

    @Test
    public void freqQuery0() {
        List<Integer> result = freqQuery(Arrays.asList(
                Arrays.asList(1, 5),
                Arrays.asList(1, 6),
                Arrays.asList(3, 2),
                Arrays.asList(1, 10),
                Arrays.asList(1, 10),
                Arrays.asList(1, 6),
                Arrays.asList(2, 5),
                Arrays.asList(3, 2)
        ));
        assertThat(result, contains(0, 1));
    }

    @Test
    public void freqQuery1() {
        List<Integer> result = freqQuery(Arrays.asList(
                Arrays.asList(3, 4),
                Arrays.asList(2, 1003),
                Arrays.asList(1, 16),
                Arrays.asList(3, 1)
        ));
        assertThat(result, contains(0, 1));
    }

    @Test
    public void freqQuery2() {
        List<Integer> result = freqQuery(Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(3, 2),
                Arrays.asList(1, 4),
                Arrays.asList(1, 5),
                Arrays.asList(1, 5),
                Arrays.asList(1, 4),
                Arrays.asList(3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 2)
        ));
        assertThat(result, contains(0, 1, 1));
    }

    @Test
    public void freqQueryRemovingSameElementMultipleTimes() {
        List<Integer> result = freqQuery(Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(2, 3),
                Arrays.asList(3, 2),
                Arrays.asList(1, 4),
                Arrays.asList(1, 5),
                Arrays.asList(1, 5),
                Arrays.asList(1, 4),
                Arrays.asList(3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 2)
        ));
        assertThat(result, contains(0, 1, 1));
    }

    @Test
    public void freqQueryCase4() throws FileNotFoundException {
        List<List<Integer>> queries = getInput("src/test/resources/interview/dictionarieshashmaps/frequencyQueries/testCase4");
        List<Integer> result = freqQuery(queries);
        assertThat(result, contains(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
    }

    private List<List<Integer>> getInput(String path) throws FileNotFoundException {
        Scanner input = new Scanner(new File(path));

        int q = Integer.parseInt(input.nextLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> queries.add(
                Stream.of(input.nextLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
        ));
        return queries;
    }
}