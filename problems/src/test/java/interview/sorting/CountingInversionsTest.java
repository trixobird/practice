package interview.sorting;

import io.happyharbor.testscore.annotations.IntArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CountingInversionsTest {

    @Test
    @Parameters({
            "7;5;3;3;1, 9",
            "7;5;3;1, 6",
            "2;1;3;1;2, 4",
            "2;4;1, 2",
            "1;1;1;2;2, 0",
            "1;5;3;7, 1",
            "1;3;5;7, 0",
            "3;2;1, 3",
    })
    public void countInversions(@IntArrayParam final int[] input, int expectedOutput) {
        assertEquals(expectedOutput, CountingInversions.countInversions(input));
    }
}