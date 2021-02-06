package fb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PairSumsTest {

    @Test
    public void test() {
        int sum = new PairSums().numberOfWays(new int[]{1, 1, 2, 5}, 3);

        assertEquals(2, sum);
    }
}
