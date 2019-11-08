package interview.sorting;

import cy.happyharbor.testscore.annotations.IntArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class MarkAndToysTest {

    @Test
    @Parameters({
            "1;2;3;4, 7, 3",
            "1;12;5;111;200;1000;10, 50, 4"
    })
    public void maximumToys(@IntArrayParam final int[] input, int k, int expectedOutput) {
        assertEquals(expectedOutput, MarkAndToys.maximumToys(input, k));
    }
}