package it.sevenbits.app.io.writer.implementation;

import it.sevenbits.app.io.closable.ClosableException;
import it.sevenbits.app.io.closable.IClosable;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter implements IWriter, IClosable {

    private BufferedWriter bufferedWriter;

    public FileWriter(final String path) throws WriterException {
        try {
            bufferedWriter = new BufferedWriter(new java.io.FileWriter(path));
        } catch (IOException e) {
            throw new WriterException("Error opening file", e);
        }
    }


    @Override
    public void write(final char symbol) throws WriterException {
        try {
            bufferedWriter.write(symbol);
        } catch (IOException e) {
            throw new WriterException("Error writing", e);
        }
    }

    @Override
    public void close() throws ClosableException {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new ClosableException("Error closing", e);
        }
    }
}
