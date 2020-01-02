package wallethub;

import cy.happyharbor.testscore.annotations.StringArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
@RunWith(JUnitParamsRunner.class)
public class GasStationTest {

    @Test
    @Parameters({
            "5;3:3;1:2;2:2;3:2;4:3, 3",
            "5;3:3;3:2;2:5;3:2;1:2;4:2, 4",
            "4;3:1;2:2;1:2;0:1, 1",
            "4;1:1;2:2;1:2;0:1, impossible",
            "4;0:1;2:2;1:2;3:1, 4",
    })
    public void gasStation(@StringArrayParam final String[] arr, final String expectedResult) {
        assertEquals(expectedResult, GasStation.gasStation(arr));
    }
}