package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;

public class CopyFormatter implements IFormatter {


    @Override
    public void format(IReader in, IWriter out) throws FormatterException {
        try {
            char currentSymbol;
            while (in.hasNext()) {
                currentSymbol = in.readChar();
                out.write(currentSymbol);
            }
        } catch (ReaderException e) {
            throw new FormatterException("Error reading", e);
        } catch (WriterException e) {
            throw new FormatterException("Error writing", e);
        }
    }
}
