package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Readers;

import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

public class Problem22Names implements Problem {

    @Override
    public String getMessage() {
        return "The sum of the name scores of the given list of names is: ";
    }

    @Override
    public int getProblemNumber() {
        return 22;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return sumOfNameScores(runner.getFileReader("22"));
    }

    public int sumOfNameScores(Reader reader) throws IOException {
        final List<String> names = Readers.readCommaSeparatedValues(reader);
        Collections.sort(names);
        int sum = 0;
        for (int i = 1; i <= names.size(); i++) {
            sum += valueOf(names, i);
        }
        return sum;
    }

    public int valueOf(List<String> names, int position) {
        if (position < 1 || position > names.size()) {
            return 0;
        }

        final String name = names.get(position - 1);
        int sum = 0;
        for (char c : name.toCharArray()) {
            sum += (int) Character.toUpperCase(c) - 'A' + 1;
        }
        return sum * position;
    }

}
