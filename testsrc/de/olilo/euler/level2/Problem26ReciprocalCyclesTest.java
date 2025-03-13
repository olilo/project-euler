package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Problem26ReciprocalCyclesTest {

    @Test
    public void testGetUnitFraction() throws Exception {
        final BigDecimal expected = BigDecimal.valueOf(0.125).setScale(10000, RoundingMode.HALF_UP);
        final BigDecimal actual = new Problem26ReciprocalCycles().getUnitFraction(8);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetRecurringCycle() throws Exception {
        final String expected = "142857";
        final String actual = new Problem26ReciprocalCycles().getRecurringCycle(BigDecimal.ONE.divide(BigDecimal.valueOf(7.0), 1000, RoundingMode.DOWN));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetRecurringCycle2() throws Exception {
        final String expected = "6";
        final String actual = new Problem26ReciprocalCycles().getRecurringCycle(BigDecimal.ONE.divide(BigDecimal.valueOf(6.0), 1000, RoundingMode.DOWN));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetRecurringCycle3() throws Exception {
        final String expected = "1406469760900";
        final String actual = new Problem26ReciprocalCycles().getRecurringCycle(BigDecimal.ONE.divide(BigDecimal.valueOf(711.0), 1000, RoundingMode.DOWN));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetRecurringCycle4() throws Exception {
        final String expected = "787401574803149606299212598425196850393700";
        System.out.println(BigDecimal.ONE.divide(BigDecimal.valueOf(127.0), 1000, RoundingMode.DOWN));
        final String actual =  new Problem26ReciprocalCycles().getRecurringCycle(BigDecimal.ONE.divide(BigDecimal.valueOf(127.0), 1000, RoundingMode.DOWN));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetUnitFractionWithLongestRecurringCycle() {
        final int expected = 7;
        final int actual = new Problem26ReciprocalCycles().getUnitFractionWithLongestRecurringCycle(10);
        Assert.assertEquals(expected, actual);
    }

}
