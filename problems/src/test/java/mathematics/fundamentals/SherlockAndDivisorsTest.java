package mathematics.fundamentals;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static mathematics.fundamentals.SherlockAndDivisors.divisors;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SherlockAndDivisorsTest {

    @Test
    @Parameters({
//            "2100, 22",
            "9, 0",
            "24, 6",
            "8, 3",
            "2, 1",
            "1, 0"
    })
    public void divisorsTest(final int input, final int expectedResult) {
        assertEquals(expectedResult, divisors(input));
    }
}
