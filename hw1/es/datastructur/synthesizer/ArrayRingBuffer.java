package es.datastructur.synthesizer;
import java.util.Iterator;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T>  implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] array;

    private int capacity;

    private int size;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        this.capacity = capacity;
        this.size = 0;
        this.first = 0;
        this.last = 0;
        array = (T[]) new Object[capacity];
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public int fillCount() {
        return this.size;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update
        //       last.
        if (isFull()) {
            throw new IllegalCallerException("The queue is full!");
        }
        array[last] = x;
        last = (last + 1) % capacity;
        size ++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first.
        if (isEmpty()) {
            throw new IllegalCallerException("The queue is Empty!");
        }
        T out = array[first];
        first = (first + 1) % capacity;
        size -= 1;
        return out;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should
        //       change.
        if (isEmpty()) {
            throw new IllegalCallerException("The queue is Empty!");
        }
        return array[first];
    }

    private class ArrayRingBufferIterator<T> implements Iterator<T> {
        private int pos;
        public ArrayRingBufferIterator(){
            pos = first;
        }

        public boolean hasNext() {
            return first != last;
        }
        public T next() {
            T value = (T) array[pos];
            pos = (pos + 1) % capacity;
            return value;
        }

    }

    @Override
    public Iterator<T> iterator()
    {
        return new ArrayRingBufferIterator<T>();
    }

    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.
}
    // TODO: Remove all comments that say TODO when you're done.
