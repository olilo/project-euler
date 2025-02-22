package de.olilo.euler.level2;

import java.util.ArrayList;
import java.util.List;

import de.olilo.util.PrimesIterable;

class Problem41PandigitalPrime {
	/**
	 * Generate all permutations of the given list.
	 *
	 * @param original the original list
	 * @return a list of all permutations of the given list
	 * @param <E>
	 */
	protected <E> List<List<E>> generatePermutation(List<E> original) {
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

	protected List<List<Integer>> generateAllPandigitalNumbersWithLength(int length) {
		List<Integer> digitals = new ArrayList<>();
		for (int i = 1; i <= length; i++) {
			digitals.add(i);
		}
		return generatePermutation(digitals);
	}

	public int findLargestPandigitalPrime() {
		int largestFoundPandigitalPrime = 0;
		for (List<Integer> number : generateAllPandigitalNumbersWithLength(7)) {
			StringBuilder pandigitalAsString = new StringBuilder();
			for (int digit : number) {
				pandigitalAsString.append(digit);
			}
			int possiblePandigitalNumber = Integer.parseInt(pandigitalAsString.toString());
			if (PrimesIterable.INSTANCE.isPrime(possiblePandigitalNumber) && possiblePandigitalNumber > largestFoundPandigitalPrime) {
				largestFoundPandigitalPrime = possiblePandigitalNumber;
			}
		}

		return largestFoundPandigitalPrime;
	}

}
