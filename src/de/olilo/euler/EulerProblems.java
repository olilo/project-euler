package de.olilo.euler;

import java.util.*;

/**
 * Main class that executes all problems and prints them out.
 *
 * Also prints out a statistic at the end with:
 * which problem needed the longest time and
 * what the average time needed was and
 * the total time needed.
 */
public class EulerProblems {

    public static void main(String[] args) throws Exception {
        final long startTime;

        final ReflectionBasedRunner runner = new ReflectionBasedRunner();

        if (args.length >= 1 && !args[0].isEmpty() && !args[1].equals("${problems}")) {
            final List<Integer> problemsToRun = new ArrayList<>();
            for (String problemAsString : args[1].split(",", -1)) {
                problemsToRun.add(Integer.parseInt(problemAsString));
            }
            runner.setProblemsToRun(problemsToRun);
        }

        final Map<Integer, Long> timestamps = new LinkedHashMap<>(runner.runProblemsWith(System.out));
        startTime = runner.getStartTime();

        System.out.println();
        System.out.println("Solved all " + timestamps.size() + " problems");
        LongestDurationStatistic longest = findLongestRuntime(timestamps, startTime);
        System.out.printf("Average time needed: %.2fms; longest time: %dms (problem #%d); total time: %dms\n",
                averageOf(timestamps.values(), startTime),
                longest.getDuration(), longest.getIndex(),
                totalTime(timestamps.values(), startTime));
    }

    static double averageOf(Collection<Long> timestamps, long start) {
        return ((double) totalTime(timestamps, start)) / timestamps.size();
    }

    static long totalTime(Collection<Long> timestamps, long start) {
        return timestamps.stream().reduce(0L, Long::max) - start;
    }

    static LongestDurationStatistic findLongestRuntime(Map<Integer, Long> timestamps, long start) {
        final LongestDurationStatistic statistic = new LongestDurationStatistic();
        long previous = start;
        for (Map.Entry<Integer, Long> problemTimestamp : timestamps.entrySet()) {
            statistic.checkAndUpdate(problemTimestamp.getValue() - previous, problemTimestamp.getKey());
            previous = problemTimestamp.getValue();
        }
        return statistic;
    }

}
