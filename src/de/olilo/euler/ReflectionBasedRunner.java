package de.olilo.euler;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

public class ReflectionBasedRunner extends AbstractRunner {
    @Override
    protected void initFileReaders() throws IOException {
    }

    @Override
    public void runProblems(PrintStream out) throws IOException {
        try (ScanResult scanResult = new ClassGraph().enableAllInfo().acceptPackages("de.olilo.euler").scan()) {
            ClassInfoList problemClasses = scanResult.getClassesImplementing("de.olilo.euler.Problem");
            for (Class<? extends Problem> problemClass : problemClasses.loadClasses(Problem.class)) {
                Problem problem = problemClass.getConstructor().newInstance();
                problem.initialize(this);
                out.println("Problem " + problem.getProblemNumber() + ": " + problem.getMessage() + problem.runProblem(this));
                problemFinished();
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            // TODO
            throw new RuntimeException(e);
        }
    }
}
