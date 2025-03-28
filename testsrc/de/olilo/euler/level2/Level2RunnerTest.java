package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Level2RunnerTest {

    @Test
    public void testRunProblemsWith() throws Exception {
        final PrintStream dummyStream = new PrintStream(new OutputStream() {
            @Override
            public void write(final int b) throws IOException {
            }
        });

        final Map<Integer, Long> result = new HashMap<>();
        final Thread levelThread = new Thread() {
            @Override
            public void run() {
                try {
                    result.putAll(new Level2Runner().runProblemsWith(dummyStream));
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
        levelThread.start();
        levelThread.join(15000);
        if (levelThread.isAlive()) {
            Assert.fail("Running level 2 needed too much time, more than 15 seconds");
        } else {
            dummyStream.close();
            Assert.assertFalse("No results from Level2Runner :(", result.isEmpty());
        }
    }

    @Test
    public void testCountFinishedProblems() throws Exception {
        final int expected = 0;
        final int actual = new Level2Runner().countFinishedProblems();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testProblemFinished() throws Exception {
        final Level2Runner runner = new Level2Runner();
        runner.problemFinished();

        final int expected = 1;
        final int actual = runner.countFinishedProblems();
        Assert.assertEquals(expected, actual);
    }

}
