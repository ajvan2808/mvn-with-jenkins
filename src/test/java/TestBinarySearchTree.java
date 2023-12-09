import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.example.binarySearchTree;

public class TestBinarySearchTree {
    private binarySearchTree bst;

    @Before
    public void SetUp() throws Exception {
        bst = new binarySearchTree();
    }

    @Test
    public void Insert() throws Exception {
        bst.insert(0, "Hanh");
        bst.insert(3, "Nhu");
        bst.insert(4, "Man");
        bst.insert(5, "Sunny");
        bst.insert(7, "Hihi");

        Assert.assertEquals("Nhu", bst.find(3));
        Assert.assertEquals("Hanh", bst.find(0));
        Assert.assertEquals("Man", bst.find(4));
        Assert.assertEquals("Sunny", bst.find(5));
        Assert.assertEquals("Hihi", bst.find(7));
    }

    @Test
    public void deleteNoChild() throws Exception {
        bst.insert(4, "Man");
        bst.insert(5, "Sunny");
        bst.insert(7, "Hihi");
        bst.insert(0, "Hanh");

        bst.delete(0);

        Assert.assertNull(bst.find(0));
    }

    @Test
    public void deleteOneChild() throws Exception {
        bst.insert(4, "Man");
        bst.insert(5, "Sunny");
        bst.insert(7, "Hihi");
        bst.insert(0, "Hanh");

        bst.delete(7);

        Assert.assertNull(bst.find(7));
    }

    @Test
    public void deleteTwoChild() throws Exception {
        bst.insert(4, "Man");
        bst.insert(5, "Sunny");
        bst.insert(7, "Hihi");
        bst.insert(0, "Hanh");

        bst.delete(5);

        Assert.assertNull(bst.find(5));
    }
}
