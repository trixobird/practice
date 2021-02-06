package wallethub;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class StringScrambleTest {

    @Test
    @Parameters({
            "coodrebtqqkye, codrebtqq, true",
            "cdore, coder, true",
            "h3llko, hello, false",
    })
    public void stringScramble(String s1, String s2, String expected) {
        assertEquals(expected, StringScramble.stringScramble(s1, s2));
    }
}