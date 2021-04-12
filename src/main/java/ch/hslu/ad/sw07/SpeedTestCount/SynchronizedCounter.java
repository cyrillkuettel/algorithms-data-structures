package ch.hslu.ad.sw07.SpeedTestCount;

public final class SynchronizedCounter implements Counter {

    private int counter = 0;

    @Override
    public synchronized void increment() {
        counter++;
    }

    @Override
    public synchronized void decrement() {
        counter--;
    }

    @Override
    public synchronized int get() {
        return counter;
    }
}
