public final class Semaphore {

    private int count; // Semaphorenzähler
    private int waitingAcquiriesCount;
    private int waitingReleasesCount;
    private final int semaphoreLimit;


    public Semaphore() {
        this(0);
    }


    public Semaphore(final int permits) throws IllegalArgumentException {
        this(permits, Integer.MAX_VALUE);
    }

    public Semaphore(final int permits, final int limit) throws IllegalArgumentException {
        if (permits < 0) {
            throw new IllegalArgumentException(permits + " < 0");
        }
        if (permits > limit) {
            throw new IllegalArgumentException("permits > limit");
        }
        count = permits;
        semaphoreLimit = limit;
        waitingAcquiriesCount = 0;
        waitingReleasesCount = 0;
    }


    public synchronized void acquire() throws InterruptedException {
        while (count == 0) {
            waitingAcquiriesCount++;
            this.wait();
            waitingAcquiriesCount--;
        }
        count--;

        if (waitingReleasesCount > 0) {
            this.notifyAll();
        }
    }

    public synchronized void acquire(final int permits) throws InterruptedException {
        if (permits < 0) {
            throw new IllegalArgumentException(permits + " < 0");
        }

        for (int i = permits; i >= 0; i--) {
            acquire();
        }
    }


    public synchronized void release() throws InterruptedException {
        while (count >= semaphoreLimit) {
            waitingReleasesCount++;
            this.wait();
            waitingReleasesCount--;
        }
        count++;
        if (waitingAcquiriesCount > 0) {
            this.notifyAll();
        }
    }


    public synchronized void release(final int permits) throws InterruptedException {
        if (permits < 0) {
            throw new IllegalArgumentException(permits + " < 0");
        }

        for (int i = permits; i >= 0; i--) {
            release();
        }
    }

    public synchronized int pendingAcquiries() {
        return waitingAcquiriesCount;
    }

    public synchronized int pendingReleases() {
        return waitingReleasesCount;
    }
}

