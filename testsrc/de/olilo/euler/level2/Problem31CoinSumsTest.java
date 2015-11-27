package de.olilo.euler.level2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Problem31CoinSumsTest {

    @Test
    public void testGetPossibleSolutionsFor5() throws Exception {
        final int expected = 4;
        final int actual = new Problem31CoinSums().getPossibleSolutionsFor(5).size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPossibleSolutionsFor8() throws Exception {
        final int expected = 7;
        final int actual = new Problem31CoinSums().getPossibleSolutionsFor(8).size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPossibleSolutionsFor11() throws Exception {
        // 11x1p ; 1x2p 9x1p; 2x2p 7x1p; 3x2p 5x1p; 4x2p 3x1p;
        // 5x2p 1x1p; 1x5p 6x1p; 1x5p 1x2p 4x1p; 1x5p 2x2p 2x1p; 1x5p 3x2p;
        // 2x5p 1x1p; 1x10p 1x1p
        final List<Coins> expected = new ArrayList<>();
        expected.add(new Coins(0, 0, 0, 0, 0, 0, 0, 11));
        expected.add(new Coins(0, 0, 0, 0, 0, 0, 1, 9));
        expected.add(new Coins(0, 0, 0, 0, 0, 0, 2, 7));
        expected.add(new Coins(0, 0, 0, 0, 0, 0, 3, 5));
        expected.add(new Coins(0, 0, 0, 0, 0, 0, 4, 3));
        expected.add(new Coins(0, 0, 0, 0, 0, 0, 5, 1));
        expected.add(new Coins(0, 0, 0, 0, 0, 1, 0, 6));
        expected.add(new Coins(0, 0, 0, 0, 0, 1, 1, 4));
        expected.add(new Coins(0, 0, 0, 0, 0, 1, 2, 2));
        expected.add(new Coins(0, 0, 0, 0, 0, 1, 3, 0));
        expected.add(new Coins(0, 0, 0, 0, 0, 2, 0, 1));
        expected.add(new Coins(0, 0, 0, 0, 1, 0, 0, 1));
        final List<Coins> actual = new Problem31CoinSums().getPossibleSolutionsFor(11);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPossibleSolutionsFor20() throws Exception {
        // 20x1p ; 1x2p 18x1p; 2x2p 16x1p; 3x2p 14x1p; 4x2p 12x1p;
        // 5x2p 10x1p; 6x2p 8x1p; 7x2p 6x1p; 8x2p 4x1p; 9x2p 2x1p;
        // 10x2p; 1x5p 15x1p; 1x5p 1x2p 13x1p; 1x5p 2x2p 11x1p; 1x5p 3x2p 9x1p;
        // 1x5p 4x2p 7x1p; 1x5p 5x2p 5x1p; 1x5p 6x2p 3x1p; 1x5p 7x2p 1x1p; 2x5p 10x1p;
        // 2x5p 1x2p 8x1p; 2x5p 2x2p 6x1p; 2x5p 3x2p 4x1p; 2x5p 4x2p 2x1p; 2x5p 5x2p;
        // 3x5p 5x1p; 3x5p 1x2p 3x1p; 3x5p 2x2p 1x1p; 4x5p; 1x10p 10x1p;
        // 1x10p 1x2p 8x1p; 1x10p 2x2p 6x1p; 1x10p 3x2p 4x1p; 1x10p 4x2p 2x1p; 1x10p 5x2p;
        // 1x10p 1x5p 5x1p; 1x10p 1x5p 1x2p 3x1p; 1x10p 1x5p 2x2p 1x1p; 1x10p 2x5p; 2x10p
        // 1x20p
        final int expected = 41;
        final int actual = new Problem31CoinSums().getPossibleSolutionsFor(20).size();
        Assert.assertEquals(expected, actual);
    }
}