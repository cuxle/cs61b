import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    @Test
    public void testOffBy1() {
        OffByN ob1 = new OffByN(1);
        assertTrue(ob1.equalChars('a', 'b'));
        assertTrue(ob1.equalChars('c', 'd'));
        assertFalse(ob1.equalChars('a', 'c'));
    }

    @Test
    public void testOffBy2() {
        OffByN ob1 = new OffByN(2);
        assertTrue(ob1.equalChars('a', 'c'));
        assertTrue(ob1.equalChars('c', 'e'));
        assertFalse(ob1.equalChars('a', 'b'));
    }

    @Test
    public void testOffBy3() {
        OffByN ob1 = new OffByN(3);
        assertTrue(ob1.equalChars('a', 'd'));
        assertTrue(ob1.equalChars('c', 'f'));
        assertFalse(ob1.equalChars('a', 'e'));
    }

    @Test
    public void testOffBy4() {
        OffByN ob1 = new OffByN(4);
        assertTrue(ob1.equalChars('a', 'e'));
        assertTrue(ob1.equalChars('c', 'g'));
        assertFalse(ob1.equalChars('a', 'g'));
    }
}
