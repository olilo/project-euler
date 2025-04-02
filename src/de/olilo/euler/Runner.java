package de.olilo.euler;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public interface Runner {

    FileReader getFileReader(String alias);

    Map<Integer, Long> runProblemsWith(final PrintStream out) throws IOException;

}
