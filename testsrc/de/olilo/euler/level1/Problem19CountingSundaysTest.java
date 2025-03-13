package de.olilo.euler.level1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class Problem19CountingSundaysTest {

    @Test
    public void testCountFirstOfMonthIsSundayBetween() throws Exception {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(1901, Calendar.AUGUST, 31);
        final Date start = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        final Date finish = calendar.getTime();

        final int expected = 1;
        final int actual = new Problem19CountingSundays().countFirstOfMonthIsSundayBetween(start, finish);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountFirstOfMonthIsSundayNone() throws Exception {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(1901, Calendar.JANUARY, 1);
        final Date start = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        final Date finish = calendar.getTime();

        final int expected = 0;
        final int actual = new Problem19CountingSundays().countFirstOfMonthIsSundayBetween(start, finish);
        Assert.assertEquals(expected, actual);
    }

}
