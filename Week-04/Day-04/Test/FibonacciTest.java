import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FibonacciTest {
    @Before
    public void beforeMethod() {
        System.out.println("TEST");
    }

    @Test
    public void fibonacci_InitializedWithZero_ReturnZero() {
        assertTrue(0 == Fibonacci.fibonacci(0));
        assertTrue(0 == Fibonacci.fibonacci(-0));
    }

    @Test
    public void fibonacci_InitializedWithNegativeNumber_ReturnZero() {
        assertTrue(0 == Fibonacci.fibonacci(-1));
    }

    @Test
    public void fibonacci_InitializedWithSequence_ReturnsCorrectValues() {

        int[] fibonacciSequence = new int[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987,
                1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229,
                832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986,
                102334155};

        for (int i = 0; i < fibonacciSequence.length; i++) {
            assertTrue(fibonacciSequence[i] == Fibonacci.fibonacci(i));
        }
    }
}
