package de.olilo.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.StringReader;
import java.util.List;

public class ReadersTest {

    @Test
    public void testReadCommaSeparatedValues() throws Exception {
        final String input = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"ELIZABETH\"";
        final List<String> expected = List.of("MARY", "PATRICIA", "LINDA", "BARBARA", "ELIZABETH");
        final List<String> actual = Readers.readCommaSeparatedValues(new StringReader(input));
        Assert.assertEquals(expected, actual);
    }

}
