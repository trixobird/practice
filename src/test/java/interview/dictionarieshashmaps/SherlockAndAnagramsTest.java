package interview.dictionarieshashmaps;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SherlockAndAnagramsTest {

    @Test
    @Parameters({
            "mom, 2",
            "abba, 4",
            "abcd, 0",
            "mom, 2",
            "ifailuhkqq, 3",
            "kkkk, 10",
            "cdcd, 5",
            "ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel, 399",
            "gffryqktmwocejbxfidpjfgrrkpowoxwggxaknmltjcpazgtnakcfcogzatyskqjyorcftwxjrtgayvllutrjxpbzggjxbmxpnde, 471",
            "mqmtjwxaaaxklheghvqcyhaaegtlyntxmoluqlzvuzgkwhkkfpwarkckansgabfclzgnumdrojexnrdunivxqjzfbzsodycnsnmw, 370",
            "ofeqjnqnxwidhbuxxhfwargwkikjqwyghpsygjxyrarcoacwnhxyqlrviikfuiuotifznqmzpjrxycnqktkryutpqvbgbgthfges, 403",
            "zjekimenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenacfivtigvfsadtlytzymuwvpntngkyhw, 428",

    })
    public void sherlockAndAnagrams(final String s, final int expectedResult) {
        assertEquals(expectedResult, SherlockAndAnagrams.sherlockAndAnagrams(s));
    }
}