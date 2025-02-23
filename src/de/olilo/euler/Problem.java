package de.olilo.euler;

public interface Problem {

    default void initialize(Runner runner) {
    }

    String getMessage();

    int getProblemNumber();

    String runProblem(Runner runner);

}
