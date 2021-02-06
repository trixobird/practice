package interview.other;

import io.happyharbor.testscore.annotations.IntArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class AlternatingCoinsTest {

    @Test
    @Parameters({
            "1;1;0;1;1|2",
            "1;0;1;0;1;1|1",
            "0;1;0|0",
            "0;1;1;0|2",
            "0|0",
            "1|0",
            "0;1|0",
            "1;1|1",
            "0;0|1",
            "1;0|0",
    })
    public void solution(@IntArrayParam final int[] input, final int expectedResult) {
        assertEquals(expectedResult, new AlternatingCoins().solution(input));
    }
}