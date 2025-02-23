package de.olilo.euler;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ReflectionBasedRunner extends AbstractRunner {
    @Override
    protected void initFileReaders() throws IOException {
        // file readers are added inside the Problem instances
    }

    @Override
    public void runProblems(PrintStream out) throws IOException {
        try (ScanResult scanResult = new ClassGraph().enableAllInfo().acceptPackages("de.olilo.euler").scan()) {
            ClassInfoList problemClasses = scanResult.getClassesImplementing("de.olilo.euler.Problem");
            List<Problem> problems = new ArrayList<>();
            for (Class<? extends Problem> problemClass : problemClasses.loadClasses(Problem.class)) {
                problems.add(problemClass.getConstructor().newInstance());
            }
            problems.sort(Problem.COMPARATOR);
            for (Problem problem : problems) {
                problem.initialize(this);
                out.println("Problem " + problem.getProblemNumber() + ": " + problem.getMessage() + problem.runProblem(this));
                problemFinished();
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            // TODO Can we do something here besides throw an exception?
            throw new RuntimeException(e);
        }
    }
}
