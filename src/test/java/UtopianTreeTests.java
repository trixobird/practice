import org.junit.Assert;
import org.junit.Test;

public class UtopianTreeTests {

    @Test
    public void getHeightZeroPeriod() {
        Assert.assertEquals(1, UtopianTree.utopianTree(0));
    }

    @Test
    public void getHeightFive() {
        Assert.assertEquals(14, UtopianTree.utopianTree(5));
    }
}
