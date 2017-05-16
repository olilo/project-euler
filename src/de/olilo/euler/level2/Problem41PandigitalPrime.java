package de.olilo.euler.level2;

import java.util.ArrayList;
import java.util.List;

import de.olilo.util.PrimesIterable;

class Problem41PandigitalPrime {
	
	public boolean isPandigital(long number) {
		final String numberAsString = Long.toString(number);
		final int length = numberAsString.length();
		final boolean[] digitPresent = new boolean[length];
		for (int i = 0; i < length; i++) {
			final char digitChar = numberAsString.charAt(i);
			final int digit = Integer.parseInt(digitChar + "");
			if (digit == 0 || digit > length || digitPresent[digit - 1]) {
				return false;
			} else {
				digitPresent[digit -1] = true;
			}
		}
		
		for (int i = 0; i < length; i++) {
			if (!digitPresent[i]) {
				return false;
			}
		}
		return true;
	}
	
	public int findPandigitalPrime(List<Integer> digits, String number) {
		return -1;
	}
	
	public int findLargestPandigitalPrime() {
		for (int digitCount = 7; digitCount > 0; digitCount--) {
			final List<Integer> digits = new ArrayList<>();
			for (int i = digitCount; i > 0; i--) {
				digits.add(i);
			}
			
			int pandigitalPrime = findPandigitalPrime(digits, "");
			if (pandigitalPrime > 0) {
				return pandigitalPrime;
			}
		}
		return -1;
	}

}
