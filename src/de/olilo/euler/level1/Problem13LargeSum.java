package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem13LargeSum implements Problem {

    @Override
    public void initialize(Runner runner) throws IOException {
        Problem.super.initialize(runner);
        runner.addFileReader("13", "problemfiles/problem13numbers.txt");
    }

    @Override
    public String getMessage() {
        return "The first ten digits of the sum of the numbers in problem13numbers.txt are: ";
    }

    @Override
    public int getProblemNumber() {
        return 13;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        final List<BigInteger> numbers = readNumbersFrom(runner.getFileReader("13"));
        final BigInteger sum = numbers.stream().reduce(BigInteger.ZERO, BigInteger::add);
        return new BigInteger(firstTenDigitsOf(sum));
    }

    protected List<BigInteger> readNumbersFrom(Reader reader) throws IOException {
        try {
            final List<BigInteger> result = new ArrayList<BigInteger>();
            final BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line != null) {
                result.add(new BigInteger(line));
                line = bufferedReader.readLine();
            }
            return result;
        } finally {
            reader.close();
        }
    }

    protected String firstTenDigitsOf(BigInteger number) {
        return number.toString().substring(0, 10);
    }

}
