package de.olilo.euler;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReflectionBasedRunner extends AbstractRunner {

    private long startTime;

    private final List<Integer> problemsToRun = new ArrayList<>();

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
    protected void initFileReaders() throws IOException {
        final File filesDirectory = new File("problemfiles");
        final Pattern filePattern = Pattern.compile("problem(\\d+).*");
        for (final File problemFile : Objects.requireNonNull(filesDirectory.listFiles())) {
            if (problemFile.isFile()) {
                final Matcher matcher = filePattern.matcher(problemFile.getName());
                if (matcher.find()) {
                    final String problemNumber = matcher.group(1);
                    addFileReader(problemNumber, problemFile.toString());
                }
            }
        }
    }

    @Override
    public void runProblems(PrintStream out) {
        List<Problem> problems = findAllProblems();

        if (!this.problemsToRun.isEmpty()) {
            problems = problems.stream().filter(problem -> problemsToRun.contains(problem.getProblemNumber())).collect(Collectors.toList());
        } else {
            problems = problems.stream().filter(problem -> problem.getClass().getAnnotation(Draft.class) == null).collect(Collectors.toList());
        }

        problems.sort(Problem.COMPARATOR);

        runProblemsInternal(problems, out);
    }

    protected List<Problem> findAllProblems() {
        List<Problem> problems;

        try (ScanResult scanResult = new ClassGraph().enableAllInfo().acceptPackages("de.olilo.euler").scan()) {
            ClassInfoList problemClasses = scanResult.getClassesImplementing("de.olilo.euler.Problem");
            problems = new ArrayList<>();
            for (Class<? extends Problem> problemClass : problemClasses.loadClasses(Problem.class)) {
                try {
                    problems.add(problemClass.getConstructor().newInstance());
                } catch (NoSuchMethodException e) {
                    System.out.println("Could not find empty public constructor for " + problemClass + " - maybe class is not public?");
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    System.out.println("Could not instantiate " + problemClass + " - maybe class is not public?");
                }
            }
        }

        return problems;
    }

    protected void runProblemsInternal(List<Problem> problems, PrintStream out) {
        this.setStartTime(System.currentTimeMillis());
        for (Problem problem : problems) {
            long elapsed;
            Number result;
            try {
                problem.initialize(this);
                long start = System.nanoTime();
                result = problem.runProblem(this);
                elapsed = TimeUnit.NANOSECONDS.toMicros (System.nanoTime() - start);
            } catch (IOException e) {
                out.println("Problem " + problem.getProblemNumber() + " ran into IOException: " + e.getMessage());
                continue;
            }

            out.print("Problem " + problem.getProblemNumber() + ": " + problem.getMessage() + result);
            out.println(" (used time: " + (elapsed > 1000 ? (elapsed / 1000) + "ms" : elapsed + "µs") + ")");

            problemFinished(problem);
        }
    }

}
