package es.datastructur.synthesizer;

import java.util.Iterator;

//Note: This file will not compile until you complete task 1 (BoundedQueue).
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int capacity = (int) Math.round(SR / frequency);
        buffer = new ArrayRingBuffer<Double>(capacity);
        while (!buffer.isFull()) {
            buffer.enqueue(0.0);
        }
        //test for iterator
        Iterator<Double> iter = buffer.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        while(!buffer.isEmpty()) {
            buffer.dequeue();
        }

        while(!buffer.isFull()) {
            double r = Math.random() - 0.5;
            buffer.enqueue(r);
        }
        //
        //       Make sure that your random numbers are different from each
        //       other.
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double front = buffer.dequeue();
        double back = (front + buffer.peek()) / 2 * DECAY;
        buffer.enqueue(back);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
}
