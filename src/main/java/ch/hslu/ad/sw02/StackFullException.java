package ch.hslu.ad.sw02;

/**
 *
 * @author cyrill
 */
public class StackFullException extends RuntimeException {

    public StackFullException() {
        super();
    }

    public StackFullException (String message) {
        super(message);
    }

}
