package de.olilo.euler.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem24LexicographicPermutations {

    public long facultyOf(int number) {
        long result = 1;
        while (number > 1) {
            result *= number--;
        }
        return result;
    }

    public int[] nthPermutationOf(int[] elements, long number) {
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
