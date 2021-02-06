package interview.arrays;

import io.happyharbor.testscore.annotations.IntArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class NewYearChaosTest {

    @Test
    @Parameters({
            "1;2;3;5;4;6;7;8, 1",
            "2;1;5;3;4, 3",
            "2;5;1;3;4, -1",
            "1;2;5;3;4;7;8;6, 4",
            "5;1;2;3;7;8;6;4, -1",
            "1;2;5;3;7;8;6;4, 7"
    })
    public void minimumBribesInternal(@IntArrayParam final int[] input, int expectedResult) {
        assertEquals(expectedResult, NewYearChaos.minimumBribesInternal(input));
    }
}