package interview.warmup;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class RepeatedStringTest {

    @Test
    @Parameters({
            "abcac, 10, 4",
            "aba, 10, 7",
            "a, 1000000000000, 1000000000000",
            "b, 1000000000000, 0"
    })
    public void repeatedString(String s, long n, long expectedResult) {
        assertEquals(expectedResult, RepeatedString.repeatedString(s, n));
    }
}