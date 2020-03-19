package radix;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BracesTest {

    @Test
    @Parameters({
            "(){}[]|true",
            "(}|false",
            "[(])|false",
            "([{}])|true"
    })
    public void validate(final String input, final boolean expectedResult) {
        assertEquals(expectedResult, Braces.validate(input));
    }
}