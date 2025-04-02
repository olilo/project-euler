package de.olilo.euler.level1;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Problem19CountingSundays implements Problem {

    @Override
    public String getMessage() {
        return "The number of sundays that fell on the first of the month in the twentieth century are: ";
    }

    @Override
    public int getProblemNumber() {
        return 19;
    }

    @Override
    public Number runProblem(Runner runner) {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(1901, Calendar.JANUARY, 1);
        final Date start = calendar.getTime();
        calendar.set(2000, Calendar.DECEMBER, 31);
        final Date finish = calendar.getTime();
        return countFirstOfMonthIsSundayBetween(start, finish);
    }

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
