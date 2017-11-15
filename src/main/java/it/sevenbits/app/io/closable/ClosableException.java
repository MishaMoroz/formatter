package it.sevenbits.app.io.closable;

/**
 * Exceptions for Closable.
 */
public class ClosableException extends Exception {

    public ClosableException(final String message, final Throwable exception) {
        super(message, exception);
    }
}
