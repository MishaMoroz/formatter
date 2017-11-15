package it.sevenbits.app;

import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.formatter.implementation.FormatterJavaCode;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.implementation.StringReader;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.implementation.StringWriter;

/**
 * Class main.
 */
public class Main {

    public static void main(final String[] args) {

        IReader in = new StringReader("Hello wordld!");
        IWriter out = new StringWriter();
        IFormatter formatter = new FormatterJavaCode();
        try {
            formatter.format(in, out);
        } catch (FormatterException e) {
            e.printStackTrace();
        }

    }
}
