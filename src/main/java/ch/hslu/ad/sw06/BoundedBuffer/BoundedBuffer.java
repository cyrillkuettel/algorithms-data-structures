/*
 * Copyright 2021 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
//		System.out.println(queue.size());
		if (queue.size() == 0) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean full() {
		if (maxSize == queue.size()) {
			return true;
		} else
			return false;
	}

	@Override
	public int size() {
		return queue.size();
	}
}