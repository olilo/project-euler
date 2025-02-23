package de.olilo.euler;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReflectionBasedRunner extends AbstractRunner {

    private long startTime;

    private final List<Integer> problemsToRun = new ArrayList<>();

    @Override
    protected void initFileReaders() throws IOException {
        // file readers are added inside the Problem instances
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setProblemsToRun(List<Integer> problems) {
        this.problemsToRun.addAll(problems);
    }

    @Override
    public void runProblems(PrintStream out) throws IOException {
        List<Problem> problems;

        try (ScanResult scanResult = new ClassGraph().enableAllInfo().acceptPackages("de.olilo.euler").scan()) {
            ClassInfoList problemClasses = scanResult.getClassesImplementing("de.olilo.euler.Problem");
            problems = new ArrayList<>();
            for (Class<? extends Problem> problemClass : problemClasses.loadClasses(Problem.class)) {
                problems.add(problemClass.getConstructor().newInstance());
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            // TODO Can we do something here besides throw an exception?
            throw new RuntimeException(e);
        }

        if (!this.problemsToRun.isEmpty()) {
            problems = problems.stream().filter(new Predicate<Problem>() {
                @Override
                public boolean test(Problem problem) {
                    return problemsToRun.contains(problem.getProblemNumber());
                }
            }).collect(Collectors.toList());
        }

        problems.sort(Problem.COMPARATOR);

        this.setStartTime(System.currentTimeMillis());
        for (Problem problem : problems) {
            problem.initialize(this);
            out.print("Problem " + problem.getProblemNumber() + ": " + problem.getMessage() + problem.runProblem(this));
            problemFinished();
            long previousUsedMilliseconds = this.timestamps.size() == 1 ? this.startTime : this.timestamps.get(this.timestamps.size() - 2);
            long usedMilliseconds = this.timestamps.get(this.timestamps.size() - 1) - previousUsedMilliseconds;
            out.println(" (used time: " + usedMilliseconds + "ms)" );
        }
    }
}
