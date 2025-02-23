package de.olilo.euler.level2;

import de.olilo.euler.Runner;
import de.olilo.euler.Problem;
import de.olilo.util.Readers;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Problem42CodedTriangleNumbers implements Problem {
    @Override
    public void initialize(Runner runner) throws IOException {
        runner.addFileReader("42", "problemfiles/problem42words.txt");
    }

    @Override
    public String getMessage() {
        return "If each letter is converted to a number (A=1, B=2, etc.)," +
                "these many words out of 2000 common words are triangle numbers: ";
    }

    @Override
    public int getProblemNumber() {
        return 42;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        final Reader reader = runner.getFileReader("42");
        final List<String> words = Readers.readCommaSeparatedValues(reader);
        return countTriangleWords(words);
    }

    protected int countTriangleWords(List<String> toTest) {
        int count = 0;
        for (String word : toTest) {
            if (isTriangleNumber(convertToWordValue(word))){
                count++;
            }
        }
        return count;
    }

    protected boolean isTriangleNumber(int number) {
        int limit = (int) Math.ceil(2 * Math.sqrt(number));
        for (int n = 1; n <= limit; n++) {
            if (number == 0.5 * n * (n + 1)) {
                return true;
            }
        }
        return false;
    }

    protected int convertToWordValue(String original) {
        int sum = 0;
        for (char c : original.toUpperCase().toCharArray()) {
            sum += c - 'A' + 1;
        }
        return sum;
    }

}
