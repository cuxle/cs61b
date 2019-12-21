import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        boolean ab = offByOne.equalChars('a', 'b');
        assertTrue(ab);
        boolean ae = offByOne.equalChars('a', 'e');
        assertFalse(ae);
        boolean dd = offByOne.equalChars('&', '%');
        assertFalse(ae);
    }
}