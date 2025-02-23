package de.olilo.util;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    /**
     * Generate all permutations of the given list.
     *
     * @param original the original list
     * @return a list of all permutations of the given list
     * @param <E>
     */
    public static <E> List<List<E>> generatePermutation(List<E> original) {
        if (original.isEmpty()) {
            List<List<E>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        E firstElement = original.get(0);
        List<List<E>> returnValue = new ArrayList<>();
        List<List<E>> permutations = generatePermutation(original.subList(1, original.size()));
        for (List<E> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                List<E> temp = new ArrayList<>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }

}
