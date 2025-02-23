package de.olilo.euler;

import java.io.IOException;
import java.util.Comparator;

public interface Problem {

    Comparator<Problem> COMPARATOR = new Comparator<>() {

        @Override
        public int compare(Problem o1, Problem o2) {
            return o1.getProblemNumber() - o2.getProblemNumber();
        }
    };

    default void initialize(Runner runner) throws IOException {
    }

    String getMessage();

    int getProblemNumber();

    Number runProblem(Runner runner) throws IOException;

}
