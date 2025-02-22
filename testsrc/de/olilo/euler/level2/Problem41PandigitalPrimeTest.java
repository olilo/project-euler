package de.olilo.euler.level2;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.olilo.util.PrimesIterable;

public class Problem41PandigitalPrimeTest {

	@Test
	public void testGeneratePermutation() {
		final List<List<Integer>> expected = List.of(
				List.of(1, 2, 3), List.of(2, 1, 3), List.of(2, 3, 1), List.of(1, 3, 2), List.of(3, 1, 2), List.of(3, 2, 1)
		);
		final List<List<Integer>> actual = new Problem41PandigitalPrime().generatePermutation(List.of(1, 2, 3));
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGenerateAllPandigitalNumbersWithLength2() {
		final List<List<Integer>> expected = List.of(List.of(1, 2), List.of(2, 1));
		final List<List<Integer>> actual = new Problem41PandigitalPrime().generateAllPandigitalNumbersWithLength(2);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGenerateAllPandigitalNumbersWithLength3() {
		final List<List<Integer>> expected = List.of(
				List.of(1, 2, 3), List.of(2, 1, 3), List.of(2, 3, 1), List.of(1, 3, 2), List.of(3, 1, 2), List.of(3, 2, 1)
		);
		final List<List<Integer>> actual = new Problem41PandigitalPrime().generateAllPandigitalNumbersWithLength(3);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testFindLargestPandigitalPrime() {
		final int expected = 7652413;
		final int actual = new Problem41PandigitalPrime().findLargestPandigitalPrime();
		Assert.assertEquals(expected, actual);
	}

}
