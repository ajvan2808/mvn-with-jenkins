import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.example.hashTable;

public class TestHashTable {
    private hashTable HashTable;

    @Before
    public void setUp() throws Exception {
        HashTable = new hashTable();
    }

    @Test
    public void PutAndGet() {
        HashTable.put("John Smith", "521-1234");
        HashTable.put("Lisa Smith", "521-8976");
        HashTable.put("Sam Doe", "521-5053");
        HashTable.put("Sandra Dee", "521-9655");
        HashTable.put("Ted Baker", "418-4165");

        Assert.assertEquals("521-1234", HashTable.get("John Smith"));
        Assert.assertEquals("521-8976", HashTable.get("Lisa Smith"));
        Assert.assertEquals("521-5053", HashTable.get("Sam Doe"));
        Assert.assertEquals("521-9655", HashTable.get("Sandra Dee"));
        Assert.assertEquals("418-4165", HashTable.get("Ted Baker"));
    }

    @Test
    public void Collision() {
        // these key will collide
        HashTable.put("John Smith", "521-1234");
        HashTable.put("Sandra Dee", "521-9655");

        Assert.assertEquals("521-1234", HashTable.get("John Smith"));
        Assert.assertEquals("521-9655", HashTable.get("Sandra Dee"));

    }
}