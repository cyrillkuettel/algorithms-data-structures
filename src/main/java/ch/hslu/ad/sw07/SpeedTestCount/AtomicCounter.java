package ch.hslu.ad.sw07.SpeedTestCount;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread-sicherer Zähler mit AtomicInteger.
 */

public final class AtomicCounter implements Counter {

    public AtomicCounter() {
    }
    
    
    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void increment() {
        counter.incrementAndGet();
    }

    @Override
    public void decrement() {
        counter.decrementAndGet();
    }

    @Override
    public int get() {
        return counter.get();
    }
}
