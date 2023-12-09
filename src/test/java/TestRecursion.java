import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.example.recursion;

public class TestRecursion {
    private recursion Recursion;

    @Before
    public void SetUp() {
        Recursion = new recursion();
    }

    @Test
    public void StripZeros() throws Exception {
        Assert.assertEquals("99", Recursion.stripZeros("000099"));
        Assert.assertEquals("vhh", Recursion.stripZeros("000vhh"));
        Assert.assertEquals("sunny", Recursion.stripZeros("0000000sunny"));
        Assert.assertEquals("sad flower", Recursion.stripZeros("sad flower"));
    }
}
