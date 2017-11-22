package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;

import java.io.IOException;

public class CopyFormatter implements IFormatter {


    @Override
    public void format(final IReader in, final IWriter out) throws FormatterException {
        try {
            char ch;
            char prevCh = ' ';
            int indLvl = 0;
            while (in.readNext()) {
                ch = in.getChar();
                if (ch != ' ' && ch != '\n') {
                    if (ch == '{') {
                        out.write(' ');
                        indLvl++;
                    }
                    if (ch == '}') {
                        indLvl--;
                        out.indent(indLvl);
                    }
                    if (prevCh == ';' || prevCh == '{' || prevCh == '}') {
                        out.write('\n');
                        out.indent(indLvl);
                    }
                    out.write(ch);
                    prevCh = ch;
                }
            }
        } catch (ReaderException e) {
            throw new FormatterException("Reading error", e);
        } catch (WriterException e) {
            throw new FormatterException("Writing error", e);
        } catch (IOException e) {
        }
    }
}
