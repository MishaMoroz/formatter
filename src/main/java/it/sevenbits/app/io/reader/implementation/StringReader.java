package it.sevenbits.app.io.reader.implementation;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;

public class StringReader implements IReader {

    private String value;
    private int index;

    public StringReader(final String value) {

        this.value = value;
    }

    @Override
    public Boolean hasNext() throws ReaderException {
        return index < value.length();
    }

    @Override
    public char readChar() throws ReaderException {

        try {
            return value.charAt(index++);
        } catch (StringIndexOutOfBoundsException e) {
            throw new ReaderException("Attempting to read outside of the string", e);
        }
    }
}
