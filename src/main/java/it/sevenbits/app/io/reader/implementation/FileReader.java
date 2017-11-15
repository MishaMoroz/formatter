package it.sevenbits.app.io.reader.implementation;

import it.sevenbits.app.io.closable.ClosableException;
import it.sevenbits.app.io.closable.IClosable;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader implements IReader, IClosable {

    private BufferedReader bufferedReader;
    private int currentSymbolId;

    public FileReader(final String pathFile) throws ReaderException {
        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(pathFile));
        } catch (FileNotFoundException e) {
            throw new ReaderException("Error reading", e);
        }
    }

    @Override
    public Boolean hasNext() throws ReaderException {
        try {
            currentSymbolId = bufferedReader.read();
            return currentSymbolId > -1;
        } catch (IOException e) {
            throw new ReaderException("Attempting to read outside of the input stream", e);
        }
    }

    @Override
    public char readChar() throws ReaderException {
        return (char) currentSymbolId;
    }

    @Override
    public void close() throws ClosableException {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new ClosableException("Error closing", e);
        }
    }
}
