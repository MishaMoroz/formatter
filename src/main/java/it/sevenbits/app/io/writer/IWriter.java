package it.sevenbits.app.io.writer;

import java.io.IOException;

public interface IWriter {

    void write(final char symbol) throws WriterException;
    void indent(int lvl) throws IOException;
}
