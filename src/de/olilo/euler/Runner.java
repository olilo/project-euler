package de.olilo.euler;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public interface Runner {

    void addFileReader(String alias, String filename) throws IOException;

    FileReader getFileReader(String alias);

    void runProblems(final PrintStream out) throws IOException;

}
