import org.junit.Before;
import org.junit.Test;
import org.example.AVLtree;

public class testAVLTree {
    private AVLtree avl;

    @Before
    public void setUp() {
        avl = new AVLtree();
    }

    @Test
    public void LeftLeft() {
        avl.insert(30);
        avl.insert(20);
        avl.insert(10);

        /*
            30                20
           /                 /  \
          20          ->    10  30
         /
        10  

        */
        avl.preOrder(avl.root);
    }

    @Test
    public void RightRight() {
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);

        avl.preOrder(avl.root);
    }

    /*
        30                40
          \              /  \
          40      ->    30  50
           \
           50
    
    */
    

    @Test
    public void LeftRight() {
        avl.insert(30);
        avl.insert(20);
        avl.insert(25);

        avl.preOrder(avl.root);
    }

    /*
        30              30          25
        /               /          / \
       20      ->      25     ->  20 30
        \              /
        25            20
    
    */

}
