package de.olilo.euler;

import de.olilo.euler.level1.Level1Runner;
import de.olilo.euler.level2.Level2Runner;

import java.util.ArrayList;
import java.util.List;

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
        final List<Long> timestamps = new ArrayList<>();

        if (args.length >= 1 && args[0].equals("reflection")) {
            final ReflectionBasedRunner runner = new ReflectionBasedRunner();

            if (args.length >= 2) {
                final List<Integer> problemsToRun = new ArrayList<>();
                for (String problemAsString : args[1].split(",", -1)) {
                    problemsToRun.add(Integer.parseInt(problemAsString));
                }
                runner.setProblemsToRun(problemsToRun);
            }

            timestamps.addAll(runner.runProblemsWith(System.out));
            startTime = runner.getStartTime();
        } else {
            startTime = System.currentTimeMillis();
            timestamps.addAll(new Level1Runner().runProblemsWith(System.out));
            timestamps.addAll(new Level2Runner().runProblemsWith(System.out));
        }

        System.out.println();
        System.out.println("Solved all " + timestamps.size() + " problems");
        LongestDurationStatistic longest = findLongestRuntime(timestamps, startTime);
        System.out.printf("Average time needed: %.2fms; longest time: %dms (problem #%d); total time: %dms\n",
                averageOf(timestamps, startTime),
                longest.getDuration(), longest.getIndex() + 1,
                sum(timestamps, startTime));
    }

    static double averageOf(List<Long> timestamps, long start) {
        return ((double) sum(timestamps, start)) / timestamps.size();
    }

    static long sum(List<Long> timestamps, long start) {
        return timestamps.get(timestamps.size() - 1) - start;
    }

    static LongestDurationStatistic findLongestRuntime(List<Long> timestamps, long start) {
        final LongestDurationStatistic statistic = new LongestDurationStatistic();
        long previous = start;
        for (int i = 0; i < timestamps.size(); i++) {
            long timestamp = timestamps.get(i);
            statistic.checkAndUpdate(timestamp - previous, i);
            previous = timestamp;
        }
        return statistic;
    }

}
