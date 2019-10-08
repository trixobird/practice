package interview.dictionarieshashmaps;

import cy.happyharbor.testscore.annotations.StringArrayParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class RansomNoteTest {

    @Test
    @Parameters({
            "give;me;one;grand;today;night, give;one;grand;today, true",
            "two;times;three;is;not;four, two;times;two;is;four, false",
            "ive;got;a;lovely;bunch;of;coconuts, ive;got;some;coconuts, false",
            "give;me;one;grand;today;night, give;one;grand;today;today, false",
            "give;me;one;grand;today;night;night, give;one;grand;today, true",
            "give;me;one;grand;today;today;night, give;one;grand;today, true",
            "give;me;one;grand;today;today;night, give;one;grand;today;today, true",
    })
    public void checkMagazine(@StringArrayParam final String[] magazine, @StringArrayParam final String[] note, final boolean expectedResult) {
        assertEquals(expectedResult, RansomNote.checkMagazineInternal(magazine, note));
    }
}