package it.sevenbits.app.formatter;

import it.sevenbits.app.formatter.implementation.CopyFormatter;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.reader.implementation.StringReader;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.io.writer.implementation.StringWriter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CopyFormatterTest {
    private IFormatter formatter;

    @Before
    public void setUp() {

        formatter = new CopyFormatter();
    }

    @Test
    public void simpleTest() throws WriterException, ReaderException, FormatterException {
        IReader in = new StringReader("Hello;world");
        IWriter out = new StringWriter();
        formatter.format(in, out);
        assertEquals("Hello;\nworld", out.toString());
    }

    @Test
    public void secondSimpleTest() throws WriterException, ReaderException, FormatterException {
        IReader in = new StringReader("Hello;world!!!");
        IWriter out = new StringWriter();
        formatter.format(in, out);
        assertEquals("Hello;\nworld!!!", out.toString());
    }


}
