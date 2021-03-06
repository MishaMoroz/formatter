package it.sevenbits.app.io.reader;

/**
 * Writer exception occurs when can't write to source
 */
public class ReaderException extends Exception {

    public ReaderException(final Throwable cause) {
        super(cause);
    }

    public ReaderException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
