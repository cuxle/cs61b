import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayRingBufferTest {
    static ArrayRingBuffer<Integer> buffer = new ArrayRingBuffer<>(4);
    @Test
    public void testArrayRingBuffer() {

        assertEquals(true, buffer.isEmpty());
        buffer.enqueue(10);
        assertEquals(1, buffer.fillCount());
        buffer.enqueue(10);
        assertEquals(2, buffer.fillCount());
        buffer.enqueue(10);
        assertEquals(3, buffer.fillCount());
        buffer.enqueue(10);
        assertEquals(4, buffer.fillCount());
        //buffer.enqueue(10);
        buffer.dequeue();
        assertEquals(3, buffer.fillCount());
        buffer.dequeue();
        buffer.dequeue();
        buffer.dequeue();
        assertEquals(true, buffer.isEmpty());

    }
}
