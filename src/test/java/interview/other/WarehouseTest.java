package interview.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class WarehouseTest {

    @Test
    public void fillTruck_oneTuple() {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(10, 1, 60, 35, 25));
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(4, 3));

        ArrayList<Integer> result = new Warehouse().fillTruck(90, integers);
        assertEquals(expectedResult.get(0), result.get(0));
        assertEquals(expectedResult.get(1), result.get(1));
    }

    @Test
    public void fillTruck_twoTuples() {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(10, 50, 60, 35, 25, 40));
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(0, 1));

        ArrayList<Integer> result = new Warehouse().fillTruck(90, integers);
        assertEquals(expectedResult.get(0), result.get(0));
        assertEquals(expectedResult.get(1), result.get(1));
    }

    @Test
    public void fillTruck_twoItems() {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(10, 50));
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(0, 1));

        ArrayList<Integer> result = new Warehouse().fillTruck(90, integers);
        assertEquals(expectedResult.get(0), result.get(0));
        assertEquals(expectedResult.get(1), result.get(1));
    }
}