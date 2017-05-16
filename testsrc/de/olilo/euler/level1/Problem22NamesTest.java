package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Problem22NamesTest {
    @Test
    public void testSumOfNameScores() throws Exception {
        final String input = "\"MARY\",\"COLIN\"";  // (13 + 1 + 18 + 25), (3 + 15 + 12 + 9 + 14)
        final int expected = 53 + 57 * 2;  // sorted alphabetically, colin is first
        final int actual = new Problem22Names().sumOfNameScores(new StringReader(input));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadNames() throws Exception {
        final String input = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"ELIZABETH\"";
        final List<String> expected = new ArrayList<>();
        expected.add("MARY");
        expected.add("PATRICIA");
        expected.add("LINDA");
        expected.add("BARBARA");
        expected.add("ELIZABETH");
        final List<String> actual = new Problem22Names().readNames(new StringReader(input));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testValueOf() throws Exception {
        final List<String> input = new ArrayList<>();
        input.add("SVEN");
        input.add("COLIN");
        final int expected = 53 * 2;
        final int actual = new Problem22Names().valueOf(input, 2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testValueOfFirst() throws Exception {
        final List<String> input = new ArrayList<>();
        input.add("MARY");
        input.add("COLIN");
        final int expected = 57;
        final int actual = new Problem22Names().valueOf(input, 1);
        Assert.assertEquals(expected, actual);
    }
}
