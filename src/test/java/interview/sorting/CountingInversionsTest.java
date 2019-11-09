package interview.sorting;

import cy.happyharbor.testscore.annotations.IntArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CountingInversionsTest {

    @Test
    @Parameters({
            "2;4;1, 2",
            "1;1;1;2;2, 0",
            "2;1;3;1;2, 4",
    })
    public void countInversions(@IntArrayParam final int[] input, int expectedOutput) {
        assertEquals(expectedOutput, CountingInversions.countInversions(input));
    }
}