package de.olilo.euler.level2;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.olilo.util.PrimesIterable;

public class Problem41PandigitalPrimeTest {
	
	@Test
	public void testIsPandigitalTrueWithInput2143() throws Exception {
		final boolean expected = true;
		final boolean actual = new Problem41PandigitalPrime().isPandigital(2143);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testIsPandigitalTrueWithInput698142375() throws Exception {
		final boolean expected = true;
		final boolean actual = new Problem41PandigitalPrime().isPandigital(698142375);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testIsPandigitalFalseWithInput4421() throws Exception {
		final boolean expected = false;
		final boolean actual = new Problem41PandigitalPrime().isPandigital(4421);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testIsPandigitalWithPrimes() throws Exception {
		final int prime = 4231;
		
		final boolean expected = true;
		final boolean actual = new Problem41PandigitalPrime().isPandigital(4231);
		Assert.assertEquals(expected, actual);
		
		final boolean expectedPrime = true;
		final boolean actualPrime = PrimesIterable.INSTANCE.isPrime(prime);
		Assert.assertEquals(expectedPrime, actualPrime);
	}
	
	@Test
	public void testFindPandigitalPrime() throws Exception {
		final List<Integer> digits = Arrays.asList(4, 3, 2, 1);
		
		final int expected = 4231;
		final int actual = new Problem41PandigitalPrime().findPandigitalPrime(digits, "");
		Assert.assertEquals(expected, actual);
	}

}