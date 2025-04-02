package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;

public class Problem8GreatestProduct implements Problem {

    @Override
    public String getMessage() {
        return "The greatest product of thirteen consecutive digits in the given 1000-digit number are: ";
    }

    @Override
    public int getProblemNumber() {
        return 8;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        final FileReader fileReader = runner.getFileReader("8");
        final BigInteger bigNumber = readNumberFrom(fileReader);
        return greatestProduct(bigNumber, 13);
    }

    protected BigInteger readNumberFrom(Reader input) throws IOException {
        final StringBuilder number = new StringBuilder();
        try {
            final BufferedReader reader = new BufferedReader(input);
            String line = reader.readLine();
            while (line != null) {
                number.append(line);
                line = reader.readLine();
            }
        } finally {
            input.close();
        }
        return new BigInteger(number.toString());
    }

    protected long greatestProduct(BigInteger number, int digits) {
        final String numString = number.toString();
        long max = 0;
        for (int i = 0; i < numString.length() - digits; i++) {
            long current = 1;
            for (int j = i; j < i + digits; j++) {
                current *= Integer.parseInt(numString.substring(j, j + 1));
            }
            max = Math.max(max, current);
        }
        return max;
    }

}
