package fb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotationalCipherTest {

    @Test
    public void test() {
        String res = RotationalCipher.rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39);

        assertEquals("nopqrstuvwxyzABCDEFGHIJKLM9012345678", res);
    }
}
