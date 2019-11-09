package interview.sorting;

import cy.happyharbor.testscore.annotations.IntArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FraudulentActivityNotificationsTest {

    @Test
    @Parameters({
            "1;2;100;80;70;60;70, 6, 0",
            "1;1;1;1;1;1, 1, 0",
            "1;2;3;4;4, 4, 0",
            "2;3;4;2;3;6;8;4;5, 5, 2",
            "10;20;30;40;50, 3, 1",
    })
    public void activityNotifications(@IntArrayParam final int[] input, int d, int expectedOutput) {
        assertEquals(expectedOutput, FraudulentActivityNotifications.activityNotifications(input, d));
    }
}