package interview.dictionarieshashmaps;

import cy.happyharbor.testscore.annotations.LongArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CountTripletsTest {

    @Test
    @Parameters({
            "1;4;16;4;16;64|4|6",
            "1;2;4;8;16;32;64|4|3",
            "1;4;16;64|4|2",
            "64;4;16;1|4|0",
            "1;4;16;1;4;16|4|4",
            "1;1;1;1;1;5;5;5;5|1|14",
            "1;4;4;16;16;16|4|6",
            "1;2;2;4|2|2",
            "1;3;9;9;27;81|3|6",
            "1;5;5;25;125|5|4",
            "4;16|4|0"
    })
    public void countTriplets(@LongArrayParam final long[] arr, final long r, final long expectedResult) {
        List<Long> list = Arrays
                .stream(arr)
                .boxed()
                .collect(toList());
        assertEquals(expectedResult, CountTriplets.countTriplets(list, r));
    }
    
    @Test
    public void countTripletsBigInput1r() {
        List<Long> arr = new ArrayList<>();
        for (int i = 0; i < (int) Math.pow(10, 5); i++) {
            arr.add(1237L);
        }
        assertEquals(166661666700000L, CountTriplets.countTriplets(arr, 1));
    }

    @Test
    public void countTripletsBigInput3r() throws IOException {
        Scanner input = new Scanner(new File ("src/test/resources/interview/dictionarieshashmaps/input"));

        String[] nr = input.nextLine().replaceAll("\\s+$", "").split(" ");

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(input.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());
        assertEquals(2325652489L, CountTriplets.countTriplets(arr, r));
    }
}