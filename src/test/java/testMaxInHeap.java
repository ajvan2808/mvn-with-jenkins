import org.junit.Assert;
import org.junit.Test;
import org.example.maxInHeap;

public class testMaxInHeap {
    private maxInHeap binaryHeap;

    @Test
    public void ExtractMax() throws Exception {
        binaryHeap = new maxInHeap();
        binaryHeap.insert(45);
        binaryHeap.insert(30);
        binaryHeap.insert(15);

        binaryHeap.print();

        binaryHeap.insert(35);

        // Test insert
        Assert.assertEquals(45, binaryHeap.items[0]);
        Assert.assertEquals(35, binaryHeap.items[1]);
        Assert.assertEquals(15, binaryHeap.items[2]);
        Assert.assertEquals(30, binaryHeap.items[3]);

        // Test extract Max
        Assert.assertEquals(45, binaryHeap.extractMax());
        Assert.assertEquals(35, binaryHeap.extractMax());
        Assert.assertEquals(30, binaryHeap.extractMax());
        Assert.assertEquals(15, binaryHeap.extractMax());
    }
}