package de.olilo.euler.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Problem13LargeSum {

    public List<BigInteger> readNumbersFrom(Reader reader) throws IOException {
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

    public BigInteger sumOf(final List<BigInteger> largeNumbers) {
        BigInteger result = BigInteger.ZERO;
        for (final BigInteger largeNumber : largeNumbers) {
            result = result.add(largeNumber);
        }
        return result;
    }

    public String firstTenDigitsOf(BigInteger number) {
        return number.toString().substring(0, 10);
    }

}
