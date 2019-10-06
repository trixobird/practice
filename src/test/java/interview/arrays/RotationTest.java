package interview.arrays;

import cy.happyharbor.testscore.annotations.IntArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnitParamsRunner.class)
public class RotationTest {

    @Test
    @Parameters({
            "1;2;3;4;5, 2, 3;4;5;1;2",
            "1;2;3;4;5, 4, 5;1;2;3;4",
            "1;2;3;4;5, 0, 1;2;3;4;5",
            "1;2;3;4;5, 5, 1;2;3;4;5"
    })
    public void rotLeft(@IntArrayParam final int[] input,
                        final int shift,
                        @IntArrayParam final int[] expectedResult) {
        assertArrayEquals(expectedResult, Rotation.rotLeft(input, shift));
    }

    @Test
    @Parameters({
            "1;2;3;4;5, 2, 4;5;1;2;3",
    })
    public void rotRight(@IntArrayParam final int[] input,
                        final int shift,
                        @IntArrayParam final int[] expectedResult) {
        assertArrayEquals(expectedResult, Rotation.rotRight(input, shift));
    }
}