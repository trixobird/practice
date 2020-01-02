package wallethub;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class LongestWordTest {

    @Test
    @Parameters({
            "fun&!! time, time",
            "I love dogs, love",
            "I dogs love, dogs",
    })
    public void longestWord(String input, String expected) {
        assertEquals(expected, LongestWord.longestWord(input));
    }
}