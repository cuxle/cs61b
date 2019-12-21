import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        boolean cat = palindrome.isPalindrome("cat");
        assertEquals(false, cat);
        boolean dog = palindrome.isPalindrome("dog");
        assertEquals(false, dog);
        boolean racecar = palindrome.isPalindrome("racecar");
        assertEquals(true, racecar);
        boolean noon = palindrome.isPalindrome("noon");
        assertEquals(true, racecar);

        assertFalse(palindrome.isPalindrome("noob"));

        assertTrue(palindrome.isPalindrome("a"));

        assertTrue(palindrome.isPalindrome(""));


    }
}