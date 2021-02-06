package interview.warmup;

import io.happyharbor.testscore.annotations.IntArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class JumpingOnTheCloudsTest {

    @Test
    @Parameters({
            "0;0;1;0;0;1;0, 4",
            "0;0;0;0;1;0, 3",
            "0;1;0;0;0;1;0, 3",
            "0;1;0;0;0;0, 3"
    })
    public void jumpingOnClouds(@IntArrayParam final int[] input, int expectedResult) {
        assertEquals(expectedResult, JumpingOnTheClouds.jumpingOnClouds(input));
    }
}