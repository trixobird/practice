package radix;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class WeightTest {

    @Test
    @Parameters({
            "56 65 74 100 99 68 86 180 90|100 180 90 56 65 74 68 86 99",
    })
    public void orderWeight(final String input, final String output) {
        assertEquals(output, Weight.orderWeight(input));
    }
}