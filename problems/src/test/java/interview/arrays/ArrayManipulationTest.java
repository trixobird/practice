package interview.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayManipulationTest {

    @Test
    public void arrayManipulation1() {
        int[][] input = {
                {1, 5, 3},
                {4, 8, 7},
                {6, 9, 1},
        };
        assertEquals(10, ArrayManipulation.arrayManipulation(10 , input));
    }

    @Test
    public void arrayManipulation2() {
        int[][] input = {
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100},
        };
        assertEquals(200, ArrayManipulation.arrayManipulation(10 , input));
    }

    @Test
    public void arrayManipulation3() {
        int[][] input = {
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100},
        };
        assertEquals(200, ArrayManipulation.arrayManipulation(5 , input));
    }

    @Test
    public void arrayManipulation4() {
        int[][] input = {
                {2, 6, 8},
                {3, 5, 7},
                {1, 8, 1},
                {5, 9, 15}
        };
        assertEquals(31, ArrayManipulation.arrayManipulation(10 , input));
    }
}