package wallethub;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class PalindromeTest {

    @Test
    @Parameters({
            "never odd or even, true",
            "eye, true"
    })
    public void palindrome(String input, String expected) {
        assertEquals(expected, Palindrome.palindrome(input));
    }
}