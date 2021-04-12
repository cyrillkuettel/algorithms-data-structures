
package ch.hslu.ad.sw07.SpeedTestCount;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Beispiele von komplexeren Atomic-Operationen.
 */
public final class AtomicOperations  {

    private static final AtomicLong VALUE = new AtomicLong();

    /**
     * Falsches Update, um Wert zu prüfen und falls Maximalwert, dann Speichern.
     * @param newVal zu prüfender Wert.
     */
    public static void updateWrong(final long newVal) {
        VALUE.set(Math.max(VALUE.get(), newVal));
    }

    /**
     * Wert prüfen und falls Maximalwert, dann Speichern.
     * @param newVal zu prüfender Wert.
     */
    public static void updateCorrect(final long newVal) {
        long alt, neu;
        do {
            alt = VALUE.get();
            neu = Math.max(alt, newVal);
        } while (VALUE.compareAndSet(alt, neu) == false);
    }

    /**
     * Wert prüfen und falls Maximalwert, dann Speichern. (Java 8 Version)
     * @param newVal zu prüfender Wert.
     */
    public static void update(final long newVal) {
        VALUE.accumulateAndGet(newVal, Math::max);
    }

    /**
     * Addition mit aktuellem Wert.
     * @param operand zu addierender Wert.
     * @return alter Wert.
     */
    public static long add(final long operand) {
        return VALUE.getAndAdd(operand);
    }

    /**
     * Multiplikation mit aktuellem Wert.
     * @param operand zu multiplizierender Wert.
     * @return alter Wert.
     */
    public static long mult(final long operand) {
        return VALUE.getAndUpdate((long a) -> operand * a);
    }

    /**
     * Speicher einen neuen Atomic-Wert.
     * @param newVal neuer Atomic-Wert.
     */
    public static void setValue(final long newVal) {
        VALUE.set(newVal);
    }

    /**
     * Liefert den Atomic-Wert.
     * @return Atomic-Wert.
     */
    public static Long getValue() {
        return VALUE.get();
    }
}
