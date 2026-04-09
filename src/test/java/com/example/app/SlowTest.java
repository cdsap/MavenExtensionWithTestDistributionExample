package com.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests that simulate slower-running operations — ideal candidates for
 * test distribution to remote executors.
 */
@DisplayName("Slow tests (good candidates for distribution)")
@Tag("slow")
class SlowTest {

    private final MathService mathService = new MathService();

    @Test
    void computesLargeFactorial() throws InterruptedException {
        Thread.sleep(500);
        assertEquals(3628800, mathService.factorial(10));
    }

    @Test
    void checksLargePrime() throws InterruptedException {
        Thread.sleep(700);
        assertTrue(mathService.isPrime(7919));
    }

    @Test
    void computesFibonacciSequence() throws InterruptedException {
        Thread.sleep(600);
        assertEquals(55, mathService.fibonacci(10));
        assertEquals(610, mathService.fibonacci(15));
        assertEquals(6765, mathService.fibonacci(20));
    }

    @RepeatedTest(3)
    void reverseIsInvolution() throws InterruptedException {
        Thread.sleep(300);
        String original = "test distribution";
        assertEquals(original, StringUtils.reverse(StringUtils.reverse(original)));
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 200, 500, 1000, 2000})
    void isPrimeForVariousSizes(int n) throws InterruptedException {
        Thread.sleep(400);
        // Just verify it doesn't throw
        mathService.isPrime(n);
    }

    @Test
    void palindromeCheckOnLongString() throws InterruptedException {
        Thread.sleep(800);
        String longPalindrome = "a".repeat(10_000);
        assertTrue(StringUtils.isPalindrome(longPalindrome));
    }

    @Test
    void userServiceCrudCycle() throws InterruptedException {
        Thread.sleep(500);
        UserService service = new UserService();

        UserService.User user = service.createUser("Test", "test@example.com");
        assertNotNull(user);

        assertTrue(service.findByEmail("test@example.com").isPresent());
        assertTrue(service.deleteUser(user.id()));
        assertTrue(service.findByEmail("test@example.com").isEmpty());
    }

    @Test
    void collectionOperationsChain() throws InterruptedException {
        Thread.sleep(600);
        var list = java.util.List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        var deduped = CollectionUtils.removeDuplicates(list);
        var max = CollectionUtils.max(deduped);

        assertEquals(9, max);
        assertEquals(7, deduped.size());
    }
}
