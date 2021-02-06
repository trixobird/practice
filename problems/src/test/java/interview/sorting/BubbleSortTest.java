package interview.sorting;

import io.happyharbor.testscore.annotations.IntArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;
import org.junit.runner.RunWith;

import static interview.sorting.BubbleSort.internalCountSwaps;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BubbleSortTest {

    @Test
    @Parameters({
            "6;4;1, 3,1,6",
            "1;2;3, 0,1,3",
            "3;2;1, 3,1,3"
    })
    public void countSwaps(@IntArrayParam final int[] input, int count, int first, int last) {
        Triple<Integer, Integer, Integer> stats = internalCountSwaps(input);
        hasTriple(stats, count, first, last);
    }

    private void hasTriple(Triple<Integer, Integer, Integer> stats, int count, int first, int last) {
        assertEquals(count, (int)stats.getLeft());
        assertEquals(first, (int)stats.getMiddle());
        assertEquals(last, (int)stats.getRight());
    }
}