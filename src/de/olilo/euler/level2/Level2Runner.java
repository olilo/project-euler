package de.olilo.euler.level2;

import de.olilo.euler.AbstractLevelRunner;

import java.io.IOException;
import java.io.PrintStream;

public class Level2Runner extends AbstractLevelRunner {

    private Problem26ReciprocalCycles problem26 = new Problem26ReciprocalCycles();
    private Problem27QuadraticPrimes problem27 = new Problem27QuadraticPrimes();
    private Problem28NumberSpiralDiagonals problem28 = new Problem28NumberSpiralDiagonals();

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

        out.println("Problem 27: a * b of longest chain of quadratic primes (n² + an + b): " +
                problem27.getLongestChainOfQuadraticPrimes(1000, 1000));
        problemFinished();

        out.println("Problem 28: number spiral diagonals sum of 1001x1001 spiral: " +
                problem28.getNumberSpiralDiagonalsFor(1001));
        problemFinished();
    }
}
