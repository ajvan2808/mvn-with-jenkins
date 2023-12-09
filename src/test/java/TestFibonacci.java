import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.example.fibMemoized;
import org.example.fibonacciNaive;

public class TestFibonacci {
    private fibonacciNaive naive;
    private fibMemoized memo;
    
    @Before
    public void SetUp() {
        naive = new fibonacciNaive();
        memo = new fibMemoized();
    }

    @Test
    public void naiveFIB() throws Exception {
        Assert.assertEquals(0, naive.fib(0));
        Assert.assertEquals(1, naive.fib(1));
        Assert.assertEquals(1, naive.fib(2));
        Assert.assertEquals(2, naive.fib(3));
        Assert.assertEquals(3, naive.fib(4));
        Assert.assertEquals(5, naive.fib(5));
        Assert.assertEquals(8, naive.fib(6));
        Assert.assertEquals(13, naive.fib(7));
        Assert.assertEquals(21, naive.fib(8));
    }

    @Test
    public void memoFIB() throws Exception {
        Assert.assertEquals(0, memo.fibMemo(0));
        Assert.assertEquals(1, memo.fibMemo(1));
        Assert.assertEquals(1, memo.fibMemo(2));
        Assert.assertEquals(2, memo.fibMemo(3));
        Assert.assertEquals(3, memo.fibMemo(4));
        Assert.assertEquals(5, memo.fibMemo(5));
        Assert.assertEquals(8, memo.fibMemo(6));
        Assert.assertEquals(13, memo.fibMemo(7));
        Assert.assertEquals(21, memo.fibMemo(8));
    }
}
