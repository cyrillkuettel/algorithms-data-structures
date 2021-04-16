package ch.hslu.ad.sw06.BoundedBuffer;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;

/**
 * Puffer nach dem First In First Out Prinzip mit einer begrenzten Kapazität.
 * Der Puffer ist thread sicher.
 *
 * @param <T> Elememente des Buffers
 */
public final class BoundedBuffer<T> implements Buffer<T> {

	private final ArrayDeque<T> queue;
	private final Semaphore putSema;
	private final Semaphore takeSema;
	private final int maxSize;

	/**
	 * Erzeugt einen Puffer mit bestimmter Kapazität.
	 *
	 * @param n Kapazität des Puffers
	 */
	public BoundedBuffer(final int n) {
		queue = new ArrayDeque<>(n);
		putSema = new Semaphore(n);
		takeSema = new Semaphore(0);
		maxSize = n;
	}

	@Override
	public void put(final T elem) throws InterruptedException {
		putSema.acquire();
		synchronized (queue) {
			queue.addFirst(elem);
		}
		takeSema.release();
	}

	@Override
	public T get() throws InterruptedException {
		takeSema.acquire();
		T elem;
		synchronized (queue) {
			elem = queue.removeLast();
		}
		putSema.release();
		return elem;
	}

	@Override
	public boolean put(T elem, long millis) throws InterruptedException {
		long milSek = System.currentTimeMillis();
		while (System.currentTimeMillis() - milSek< millis) {
			putSema.acquire();
			synchronized (queue) {
				queue.addFirst(elem);
			}
			takeSema.release();
			return true;
		}
		return false;
	}

	@Override
	public T get(long millis) throws InterruptedException {
		T elem;
		long milSek = System.currentTimeMillis();
		while (System.currentTimeMillis() - milSek< millis) {
		takeSema.acquire();
		synchronized (queue) {
			elem = queue.removeLast();
		}
		putSema.release();
		return elem;
		}
		return null;
	}

	@Override
	public T first() throws InterruptedException {
		T ele;
		synchronized(queue) {
			ele = queue.getFirst();
		} return ele;
	}

	@Override
	public T last() throws InterruptedException {
		T ele;
		synchronized(queue) {
			ele = queue.getLast();
		} return ele;
		
	}

	@Override
	public boolean empty() {
            return queue.isEmpty();
	}

	@Override
	public boolean full() {
            return maxSize == queue.size();
	}

	@Override
	public int size() {
		return queue.size();
	}
}