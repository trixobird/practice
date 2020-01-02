package wallethub;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CoinDeterminerTest {

    @Test
    @Parameters({
            "3, 3",
            "25, 3",
            "6, 2",
            "16, 2",
            "1, 1",
            "2, 2",
            "4, 4",
            "5, 1",
            "6, 2",
            "7, 1",
            "8, 2",
            "9, 1",
            "10, 2",
            "11, 1",
            "12, 2",
            "13, 3",
            "14, 2",
            "15, 3",
            "16, 2",
            "17, 3",
            "18, 2",
            "19, 3",
            "20, 2",
            "21, 3",
            "12, 2",
    })
    public void coinDeterminer(int num, int expected) {
        assertEquals(expected, CoinDeterminer.coinDeterminer(num));
    }
}