package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class Level1RunnerTest {
    @Test
    public void testRunWith() throws Exception {
        final PrintStream dummyStream = new PrintStream(new OutputStream() {
            @Override
            public void write(final int b) throws IOException {
            }
        });

        final List<Long> result = new Level1Runner().runWith(dummyStream);
        dummyStream.close();
        Assert.assertFalse("No results from Level1Runner :(", result.isEmpty());
    }

    @Test
    public void testCountFinishedProblems() throws Exception {
        final int expected = 0;
        final int actual = new Level1Runner().countFinishedProblems();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testProblemFinished() throws Exception {
        final Level1Runner runner = new Level1Runner();
        runner.problemFinished();

        final int expected = 1;
        final int actual = runner.countFinishedProblems();
        Assert.assertEquals(expected, actual);
    }
}
