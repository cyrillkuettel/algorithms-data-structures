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
import java.util.concurrent.TimeUnit;

/**
 * Puffer nach dem First In First Out Prinzip mit einer begrenzten Kapazität.
 * Der Puffer ist thread sicher.
 *
 * @param <T> Elememente des Buffers
 */
public final class BoundedBuffer<T> {

    private final ArrayDeque<T> queue;
    private final Semaphore putSema; // java 
    private final Semaphore takeSema;

    private int maxSize;

    /**
     * Erzeugt einen Puffer mit bestimmter Kapazität.
     *
     * @param n Kapazität des Puffers
     */
    public BoundedBuffer(final int n) {
        queue = new ArrayDeque<>(n);
        putSema = new Semaphore(n);
        takeSema = new Semaphore(0);
        this.maxSize = n;

    }

    /**
     * Fügt ein Element in den Puffer ein, wenn dies möglich ist, wenn nicht
     * muss der Schreiber warten.
     *
     * @param elem Element zum Einfügen.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    public void put(final T elem) throws InterruptedException {
        putSema.acquire();
        synchronized (queue) {
            queue.addFirst(elem);
        }
        takeSema.release();
    }

    public boolean put(final T elem, final long millis) throws InterruptedException {
        if (!putSema.tryAcquire(millis, TimeUnit.MILLISECONDS)) {
            return false;
        }

        synchronized (queue) {
            queue.addFirst(elem);
        }
        takeSema.release();
        return true;
    }

    public T get(final long millis) throws InterruptedException {
        
        return getFirst(millis);
    }

    public T getFirst(final long millis) {
        T elem;
        elem = queue.removeFirst();
        putSema.release(); // ein slot Frei geworden
        return elem;
    }

    /**
     * Liest und entfernt ein Element aus dem Puffer, wenn dies möglich ist,
     * wenn nicht muss der Leser warten.
     *
     * @return gelesenes Element.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    public T take() throws InterruptedException {
        takeSema.acquire();
        T elem;
        synchronized (queue) {
            elem = queue.removeLast();
        }
        putSema.release();
        return elem;
    }
}
