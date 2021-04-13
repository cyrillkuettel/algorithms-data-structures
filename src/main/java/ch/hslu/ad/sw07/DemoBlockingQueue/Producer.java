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
package ch.hslu.ad.sw07.DemoBlockingQueue;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.BlockingQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Produzent, der eine maximale Anzahl Werte produziert und diese in eine Queue
 * oder in einer List speichert.
 */
public final class Producer implements Callable<Long> {

    private static final Logger LOG = LogManager.getLogger(Producer.class);
    private final List<Integer> list;
    private final int maxRange;
    private final BlockingQueue<Integer> queue;

    /**
     * Erzeugt einen Produzent, der eine bestimmte Anzahl Integer-Werte
     * produziert.
     *
     * @param list Queue zum Speichern der Integer-Werte.
     * @param max Anzahl Integer-Werte.
     */
    public Producer(final List<Integer> list, final int max) {
        this.queue = null;
        this.list = list;
        this.maxRange = max;
    }

    public Producer(final BlockingQueue<Integer> queue, final int max) {
        this.list = null;
        this.queue = queue;
        this.maxRange = max;
    }

    /**
     * Liefert die Summe aller zusammengezählter Integer Werte.
     *
     * @return Summe.
     * @throws java.lang.Exception falls Ausnahmen passieren.
     */
    @Override
    public Long call() throws Exception { // it can handle both queue and List
        long sum = 0;
        if (list == null) {
            for (int i = 1; i <= maxRange; i++) {
                sum += i;
                queue.add(i);
            }
        }
        if (queue == null) {
            for (int i = 1; i <= maxRange; i++) {
                sum += i;

                list.add(i);
            }
        }
        return sum;
    }

}
