package fb;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ContiguousSubarraysTest {

    @Test
    public void test() {
        int[] ints = ContiguousSubarrays.countSubarrays(new int[]{3, 4, 4, 6, 2});
        assertArrayEquals(new int[]{1, 3, 1, 5, 1}, ints);
    }
}
