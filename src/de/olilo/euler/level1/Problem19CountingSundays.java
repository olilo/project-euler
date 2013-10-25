package de.olilo.euler.level1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Problem19CountingSundays {

    public int countFirstOfMonthIsSundayBetween(final Date start, final Date finish) {
        final Calendar finishCalendar = new GregorianCalendar();
        finishCalendar.setTime(finish);

        // initialize calendar at start date and advance it to the next sunday
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        // now count every sunday on first of month
        int counter = 0;
        while (calendar.before(finishCalendar)) {
            if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
                counter++;
            }
            calendar.add(Calendar.DAY_OF_MONTH, 7);
        }
        return counter;
    }

}
