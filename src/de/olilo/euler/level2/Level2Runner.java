package de.olilo.euler.level2;

import de.olilo.euler.AbstractLevelRunner;

import java.io.IOException;
import java.io.PrintStream;

public class Level2Runner extends AbstractLevelRunner {

    private Problem26ReciprocalCycles problem26 = new Problem26ReciprocalCycles();

    @Override
    protected void initFileReaders() throws IOException {
    }

    @Override
    protected void runProblems(PrintStream out) throws IOException {
        runProblems26To30(out);
    }

    private void runProblems26To30(final PrintStream out) throws IOException {
        out.println("Problem 26: Longest recurring cycle for unit fractions until 1 / 1000: " +
                problem26.getUnitFractionWithLongestRecurringCycle(1000));
        problemFinished();
    }
}
