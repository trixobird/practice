package interview.other;

import cy.happyharbor.testscore.annotations.StringArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class JafarTest {

    @Test
    @Parameters({
            "..X...;......;....X.;.X....;..X.X.;...O..|2",
            "X....;.X...;..O..;...X.;.....|0"
    })
    public void solution(@StringArrayParam final String[] input, final int expectedResult) {
        assertEquals(expectedResult, new Jafar().solution(input));
    }
}