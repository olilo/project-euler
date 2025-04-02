package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.util.ArrayList;
import java.util.List;

public class Problem24LexicographicPermutations implements Problem {

    @Override
    public String getMessage() {
        return "The millionth permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9 is: ";
    }

    @Override
    public int getProblemNumber() {
        return 24;
    }

    @Override
    public Number runProblem(Runner runner) {
        final int[] resultAsInts = nthPermutationOf(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 1_000_000);
        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += resultAsInts[i] * (long) Math.pow(10, 9 - i);
        }
        return result;
    }

    protected long facultyOf(int number) {
        long result = 1;
        while (number > 1) {
            result *= number--;
        }
        return result;
    }

    protected int[] nthPermutationOf(int[] elements, long number) {
        number--;
        List<Integer> options = new ArrayList<>();
        for (int element : elements) {
            options.add(element);
        }
        int[] result = new int[elements.length];
        for (int index = 0; index < result.length; index++) {
            long faculty = facultyOf(elements.length - index - 1);
            int option = (int) (number / faculty);
            result[index] = options.get(option);
            options.remove(option);
            number -= faculty * (number / faculty);
        }
        return result;
    }

}
