
package ch.hslu.ad.sw06.Pferderennen;

/**
 * Eine Synchronisationshilfe, die es ermöglicht, einen oder mehrere Threads warten zu lassen, bis
 * diese durch andere Threads aufgeweckt werden. Latches sperren so lange, bis sie einmal ausgelöst
 * werden. Danach sind sie frei passierbar.
 */


public final class Latch implements Synch {


    private boolean open; // ist das Latch offen?

    public Latch() {
        open = false;
    }

    @Override
    public synchronized void acquire() throws InterruptedException {
        while (!open) {
            this.wait();
        }
    }

    @Override
    public synchronized void release() {
        open = true;
        notifyAll();
    }

}
