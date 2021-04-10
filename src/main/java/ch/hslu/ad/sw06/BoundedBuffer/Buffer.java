package ch.hslu.ad.sw06.BoundedBuffer;

/**
 * Puffer (First In First Out) mit einer begrenzten Kapazität. Der Puffer ist thread sicher.
 * @param <T> Element Typ.
 */
public interface Buffer<T> {

    /**
     * Ein Element T speichern. Falls der Puffer voll ist, warten bis ein Platz frei wird.
     * @param elem zu speicherndes Element.
     * @throws InterruptedException wenn das Warten unterbrochen wird.
     */
    void put(final T elem) throws InterruptedException;

    /**
     * Ein Element T speichern oder nach einem Timeout abbrechen. Falls der Puffer voll ist, warten
     * bis ein Platz frei wird.
     * @param elem zu speicherndes Element.
     * @param millis Timeout bis zum Abbruch.
     * @return true, wenn Element gespeichert wurde, false, wenn Timeout eingetreten ist.
     * @throws InterruptedException wenn das Warten unterbrochen wird.
     */
    boolean put(final T elem, final long millis) throws InterruptedException;

    /**
     * Liest und entfernt ein Element. Falls der Puffer leer ist, warten bis ein Platz belegt wird.
     * @return gelesenes Element.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    T get() throws InterruptedException;

    /**
     * Liest und entfernt ein Element oder nach einem Timeout abbrechen. Falls der Puffer leer ist,
     * warten bis ein Platz belegt wird.
     * @param millis Timeout bis zum Abbruch.
     * @return gelesenes Element.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    T get(final long millis) throws InterruptedException;

    /**
     * Liest und entfernt das erste Element. Falls der Puffer leer ist, warten bis ein Platz belegt
     * wird.
     * @return gelesenes Element.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    T first() throws InterruptedException;

    /**
     * Liest und entfernt das letzte Element. Falls der Puffer leer ist, warten bis ein Platz belegt
     * wird.
     * @return gelesenes Element.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    T last() throws InterruptedException;

    /**
     * Gibt, ob der Puffer leer ist.
     * @return true wenn der Puffer leer ist, sonst false.
     */
    boolean empty();

    /**
     * Gibt, ob der Puffer voll ist.
     * @return true wenn der Puffer voll ist, sonst false.
     */
    boolean full();

    /**
     * Gibt die Anzahl im Puffer gespeicherten Elemente zurück.
     * @return Anzahl Elemente.
     */
    int size();
}