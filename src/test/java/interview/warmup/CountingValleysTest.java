package interview.warmup;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CountingValleysTest {

    @Test
    @Parameters({
            "UDDDUDUU, 1",
            "UD, 0",
            "DU, 1",
            "DDU, 0"
    })
    public void countingValleys(String s, int expectedResult) {
        assertEquals(expectedResult, CountingValleys.countingValleys(0, s));
    }
}