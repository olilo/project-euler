package de.olilo.euler;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractLevelRunner {

    protected final List<Long> timestamps = new ArrayList<>();

    protected final Map<String, FileReader> fileReaders = new HashMap<>();

    protected void addFileReader(String alias, String filename) throws IOException {
        fileReaders.put(alias, new FileReader(filename));
    }

    protected FileReader getFileReader(String alias) {
        return fileReaders.get(alias);
    }

    protected abstract void initFileReaders() throws IOException;

    protected abstract void runProblems(final PrintStream out) throws IOException;

    protected void closeFileReaders() throws IOException {
        for (final FileReader fileReader : fileReaders.values()) {
            fileReader.close();
        }
    }

    public List<Long> runWith(final PrintStream out) throws IOException {
        initFileReaders();
        runProblems(out);
        closeFileReaders();

        return timestamps;
    }

    public int countFinishedProblems() {
        return timestamps.size();
    }

    public void problemFinished() {
        timestamps.add(System.currentTimeMillis());
    }

}
