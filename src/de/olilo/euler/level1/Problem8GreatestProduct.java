package de.olilo.euler.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;

public class Problem8GreatestProduct {

    public BigInteger readNumberFrom(Reader input) throws IOException {
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

    public long greatestProduct(BigInteger number, int digits) {
        final String numString = number.toString();
        long max = 0;
        for (int i = 0; i < numString.length() - digits; i++) {
            long current = 1;
            for (int j = i; j < i + digits; j++) {
                current *= Integer.valueOf(numString.substring(j, j + 1));
            }
            max = Math.max(max, current);
        }
        return max;
    }

}
