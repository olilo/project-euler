package de.olilo.euler;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public interface Runner {

    void addFileReader(String alias, String filename) throws IOException;

    FileReader getFileReader(String alias);

    List<Long> runProblemsWith(final PrintStream out) throws IOException;

}
