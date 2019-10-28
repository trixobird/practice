package interview.dictionarieshashmaps;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TwoStringsTest {

    @Test
    @Parameters({
            "hello, world, YES",
            "hi, world, NO",
            "a, art, YES",
            "a, a, YES"
    })
    public void twoStrings(final String s1, final String s2, final String expectedResult) {
        assertEquals(expectedResult, TwoStrings.twoStrings(s1, s2));
    }
}