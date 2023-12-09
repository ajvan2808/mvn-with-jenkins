import org.junit.Assert;
import org.junit.Test;
import org.example.common_coding_question.*;

import java.util.Stack;

public class ArrayAndStringsTest {
    private final uniqueCharacterDetector uniqueCharacter = new uniqueCharacterDetector();
    private final PermutationDetector permutationDetector = new PermutationDetector();
    private final URLConverter urlConverter = new URLConverter();
    private final OneAwayDetector oneAwayDetector = new OneAwayDetector();
    private final CompressString compressString = new CompressString();
    private final RemoveDuplicatesLinkedList linkedList = new RemoveDuplicatesLinkedList();
    private final SumLinkedList sumStack = new SumLinkedList();
    private final DetectLoopLinkedList loopLinkedList = new DetectLoopLinkedList();

    @Test
    public void UniqueCharacterDetect() {
        Assert.assertTrue(uniqueCharacter.isUnique("abcdfgh"));
        Assert.assertFalse(uniqueCharacter.isUnique("abcdfggh"));
    }

    @Test
    public void StringPermutationDetect() {
        // Given 2 strings, check if one is a permutation of the other
        Assert.assertTrue(permutationDetector.isPermutation("sunny", "ynnus"));
        Assert.assertFalse(permutationDetector.isPermutation("sunny", "hnah"));
    }

    @Test
    public void URLify() {
        // Given length of final string
        // Replaces all the space in a string ASCII symbol for space '%20'
        Assert.assertEquals("My%20Home%20Page", urlConverter.urlify("My Home Page", 16));
    }

    @Test
    public void OneAwayDetect() {
        Assert.assertTrue(oneAwayDetector.oneAway("pale","ple"));
        Assert.assertTrue(oneAwayDetector.oneAway("pales","pale"));
        Assert.assertFalse(oneAwayDetector.oneAway("pales","bale"));
        Assert.assertFalse(oneAwayDetector.oneAway("pales","bae"));
    }

    @Test
    public void CompressString() {
        // case: compressed string not shorter than original, return original
        Assert.assertEquals("aabb", compressString.compressor("aabb"));
        // return compressed string
        Assert.assertEquals("a4b2c2", compressString.compressor("aaaabbcc"));
        Assert.assertEquals("b1c4", compressString.compressor("bcccc"));
    }

    @Test
    public void setRemoveDuplicates() {
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);
        linkedList.addFront(4);
        linkedList.addFront(4);

        Assert.assertEquals("[1, 2, 3, 4]", linkedList.removeDuplicates(linkedList.current));
    }

    @Test
    public void setSumStack() {
        Stack<Object> first = new Stack<>();
        first.push(0);
        first.push(7);
        first.push(5);

        Stack<Object> second = new Stack<>();
        second.push(5);
        second.push(4);
        second.push(1);

        Assert.assertEquals("[7, 1, 5]", sumStack.sum(first, second));
    }

    @Test
    public void loopLinkedListNodeDetector() {
        // Original case: given a circular linked list,
        // create an algorithm to determine whether the linked list is circular loop
        // if you try to add an element, when there is already a cycle, it will result in an infinite loop.
        // Enhanced case: is to prevent the loop/ duplicated node at addBack step
        DetectLoopLinkedList.Node node1 = new DetectLoopLinkedList.Node(1);
        DetectLoopLinkedList.Node node2 = new DetectLoopLinkedList.Node(2);
        DetectLoopLinkedList.Node node3 = new DetectLoopLinkedList.Node(3);
        DetectLoopLinkedList.Node node4 = new DetectLoopLinkedList.Node(4);
        DetectLoopLinkedList.Node node5 = new DetectLoopLinkedList.Node(5);

        loopLinkedList.addBack(node1);
        loopLinkedList.addBack(node2);
        loopLinkedList.addBack(node3);
        loopLinkedList.addBack(node4);
        loopLinkedList.addBack(node5);

        Assert.assertTrue(loopLinkedList.addBack(node3));
    }
}