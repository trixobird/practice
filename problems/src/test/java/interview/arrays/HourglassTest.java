package interview.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HourglassTest {

    @Test
    public void hourglassSum1() {
        int[][] input = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        assertEquals(7, Hourglass.hourglassSum(input));
    }

    @Test
    public void hourglassSum2() {
        int[][] input = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        assertEquals(19, Hourglass.hourglassSum(input));
    }

    @Test
    public void hourglassSum3() {
        int[][] input = {
                {-9, -9, -9,  1, 1, 1},
                { 0, -9,  0,  4, 3, 2},
                {-9, -9, -9,  1, 2, 3},
                { 0,  0,  8,  6, 6, 0},
                { 0,  0,  0, -2, 0, 0},
                { 0,  0,  1,  2, 4, 0}
        };
        assertEquals(28, Hourglass.hourglassSum(input));
    }
}