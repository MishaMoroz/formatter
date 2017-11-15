package it.sevenbits.app;

import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.formatter.implementation.CopyFormatter;
import it.sevenbits.app.io.reader.implementation.FileReader;
import it.sevenbits.app.io.writer.implementation.FileWriter;

/**
 * Class main.
 */
public class Main {

    /**
     * Main method.
     * @param args console arguments
     * @throws Exception exception
     */
    public static void main(final String[] args) throws Exception {

        IFormatter formatter = new CopyFormatter();
        try (
                FileReader in = new FileReader(args[0]);
                FileWriter out = new FileWriter(args[1])
        )
        {

            formatter.format(in, out);
        }
    }
}
