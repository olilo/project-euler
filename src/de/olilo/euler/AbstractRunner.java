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

    public void addFileReader(String alias, String filename) throws IOException {
        fileReaders.put(alias, new FileReader(filename));
    }

    public FileReader getFileReader(String alias) {
        return fileReaders.get(alias);
    }

    protected abstract void initFileReaders() throws IOException;

    public abstract void runProblems(final PrintStream out) throws IOException;

    protected void closeFileReaders() throws IOException {
        for (final FileReader fileReader : fileReaders.values()) {
            fileReader.close();
        }
    }

    @Override
    public Map<Integer, Long> runProblemsWith(final PrintStream out) throws IOException {
        initFileReaders();
        runProblems(out);
        closeFileReaders();

        return timestamps;
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

}
