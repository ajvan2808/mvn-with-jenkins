import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.example.dynamicArrays;

public class dynamicArraysTest {
    private dynamicArrays array;

    @Before
    public void SetUp() throws Exception {
        array = new dynamicArrays<String>(2);
    }

    @Test
    public void GetAndSet() throws Exception {
        array.set(0, "a");
        Assert.assertEquals("a", array.get(0));
    }

    @Test
    public void Insert() throws Exception {
        array.add("a"); // 0
        array.add("b"); // 1
        array.add("c"); // 2

        array.insert(1, "d");

        Assert.assertEquals(4, array.size());
        Assert.assertEquals("a", array.get(0));
        Assert.assertEquals("d", array.get(1));
        Assert.assertEquals("b", array.get(2));
        Assert.assertEquals("c", array.get(3));
    }

    @Test
    public void Delete() throws Exception {
        array.add("a");
        array.add("b");
        array.add("c");

        array.delete(1);

        Assert.assertEquals(2, array.size());
        Assert.assertEquals("a", array.get(0));
        Assert.assertEquals("c", array.get(1));
    }

    @Test
    public void contains() throws Exception {
        array.add("a");
        array.add("b");
        array.add("c");

        array.contains("b");

        Assert.assertEquals(true, array.contains("b"));
        Assert.assertEquals(false, array.contains("d"));
    }

    @Test
    public void IsEmpty() throws Exception {
        array.add("a");
        array.add("b");
        array.add("c");

        array.isEmpty();

        Assert.assertTrue(true);
    }

}
