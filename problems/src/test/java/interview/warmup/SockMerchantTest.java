package interview.warmup;

import io.happyharbor.testscore.annotations.IntArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SockMerchantTest {

    @Test
    @Parameters({
            "1;2;1;2;1;3;2|2",
            "1|0",
            "1;1;1;1|2"
    })
    public void sockMerchant(@IntArrayParam final int[] input, final int expected) {
        assertEquals(expected, SockMerchant.sockMerchant(0, input));
    }
}