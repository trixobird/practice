package interview.arrays;

import cy.happyharbor.testscore.annotations.IntArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class MinimumSwaps2Test {

    @Test
    @Parameters({
            "7;1;3;2;4;5;6|5",
            "4;3;1;2;5|3",
            "2;3;4;1;5|3",
            "1;3;5;2;4;6;7|3",
            "1;2;3;4;5;6;7|0",
            "7;6;5;4;3;2;1|3",
            "8;7;6;5;4;3;2;1|4",
            "2;3;4;5;6;7;1|6",
            "1|0",
    })
    public void minimumSwaps(@IntArrayParam final int[] input, final int expectedResult) {
        assertEquals(expectedResult, MinimumSwaps2.minimumSwaps(input));
    }
}