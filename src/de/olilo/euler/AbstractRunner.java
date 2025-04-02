package de.olilo.euler;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractRunner implements Runner {

    protected int currentProblemNumber = 1;

    protected final Map<Integer, Long> timestamps = new LinkedHashMap<>();

    protected final Map<String, FileReader> fileReaders = new LinkedHashMap<>();

    protected void addFileReader(String alias, String filename) throws IOException {
        fileReaders.put(alias, new FileReader(filename));
    }

    protected void closeFileReaders() throws IOException {
        for (final FileReader fileReader : fileReaders.values()) {
            fileReader.close();
        }
    }


    public int countFinishedProblems() {
        return timestamps.size();
    }

    public void problemFinished() {
        timestamps.put(this.currentProblemNumber++, System.currentTimeMillis());
    }

    public void problemFinished(Problem problem) {
        timestamps.put(problem.getProblemNumber(), System.currentTimeMillis());
    }


    protected abstract void initFileReaders() throws IOException;

    public abstract void runProblems(final PrintStream out) throws IOException;


    @Override
    public FileReader getFileReader(String alias) {
        return fileReaders.get(alias);
    }

    @Override
    public Map<Integer, Long> runProblemsWith(final PrintStream out) throws IOException {
        try {
            initFileReaders();
            runProblems(out);
        } finally {
            closeFileReaders();
        }

        return timestamps;
    }

}
