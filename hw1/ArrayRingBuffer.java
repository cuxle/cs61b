import es.datastructur.synthesizer.BoundedQueue;

import java.util.Iterator;

public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    private int capacity;
    private T[] array;
    private int first;
    private int last;
    private int size;

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
    public ArrayRingBuffer(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.first = 0;
        this.last = 0;
        array = (T[]) new Object[capacity];
    }

    @Override
    public Iterator<T> iterator()
    {
        return new ArrayRingBufferIterator<T>();
    }
    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public int fillCount() {
        return this.size;
    }

    @Override
    public void enqueue(T x) {
        if (isFull()) {
            throw new IllegalCallerException("The queue is full!");
        }
        array[last] = x;
        last = (last + 1) % capacity;
        size ++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalCallerException("The queue is Empty!");
        }
        T out = array[first];
        first = (first + 1) % capacity;
        size -= 1;
        return out;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalCallerException("The queue is Empty!");
        }
        return array[first];
    }


}
