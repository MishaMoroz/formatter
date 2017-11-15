package it.sevenbits.app.io.reader;

public interface IReader {

    Boolean hasNext() throws ReaderException;

    char readChar() throws ReaderException;
}
