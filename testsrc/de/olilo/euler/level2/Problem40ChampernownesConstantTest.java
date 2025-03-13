package de.olilo.euler.level2;

import org.junit.Test;

import org.junit.Assert;

public class Problem40ChampernownesConstantTest {

    @Test
    public void testGetDigit8() throws Exception {
        final int expected = 8;
        final int actual = new Problem40ChampernownesConstant().getDigit(8);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDigit12() throws Exception {
        final int expected = 1;
        final int actual = new Problem40ChampernownesConstant().getDigit(12);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDigit15() throws Exception {
        final int expected = 2;
        final int actual = new Problem40ChampernownesConstant().getDigit(15);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDigit30() throws Exception {
        final int expected = 2;
        final int actual = new Problem40ChampernownesConstant().getDigit(30);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDigit31() throws Exception {
        final int expected = 0;
        final int actual = new Problem40ChampernownesConstant().getDigit(31);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDigit100() throws Exception {
        final int expected = Integer.valueOf(new Problem40ChampernownesConstant().getConstantUntil(100).toString().substring(101, 102));
        System.out.println(expected);
        final int actual = new Problem40ChampernownesConstant().getDigit(100);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDigit405() throws Exception {
        final int expected = Integer.valueOf(new Problem40ChampernownesConstant().getConstantUntil(500).toString().substring(406, 407));
        final int actual = new Problem40ChampernownesConstant().getDigit(405);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDigit803() throws Exception {
        final int expected = Integer.valueOf(new Problem40ChampernownesConstant().getConstantUntil(500).toString().substring(804, 805));
        final int actual = new Problem40ChampernownesConstant().getDigit(803);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDigit5003() throws Exception {
        final int expected = Integer.valueOf(new Problem40ChampernownesConstant().getConstantUntil(3000).toString().substring(5004, 5005));
        final int actual = new Problem40ChampernownesConstant().getDigit(5003);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDigitProduct() throws Exception {
        final int expected = 5;
        final int actual = new Problem40ChampernownesConstant().getDigitProduct(10, 2);
        Assert.assertEquals(expected, actual);
    }

}
