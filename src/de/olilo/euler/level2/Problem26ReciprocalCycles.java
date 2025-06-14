package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.PrimesIterable;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem26ReciprocalCycles implements Problem {

    @Override
    public String getMessage() {
        return "The longest recurring cycle for unit fractions until 1 / 1000 is: ";
    }

    @Override
    public int getProblemNumber() {
        return 26;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return getUnitFractionWithLongestRecurringCycle(1000);
    }

    protected int getUnitFractionWithLongestRecurringCycle(int unitFraction) {
        int longestCycle = 0;
        int result = 0;
        int count = 0;
        List<Integer> primes = new ArrayList<>();
        for (int prime : PrimesIterable.INSTANCE) {
            if (prime >= unitFraction) {
                break;
            }
            primes.add(prime);
        }
        Collections.reverse(primes);
        for (int prime : primes) {
            final String currentCycle = getRecurringCycle(getUnitFraction(prime));
            int currentCycleLen = currentCycle.length();
            if (currentCycleLen > longestCycle) {
                result = prime;
                longestCycle = currentCycleLen;
            } else {
                count++;
            }
            if (count > 5) {
                break;
            }
        }
        return result;
    }

    protected BigDecimal getUnitFraction(int d) {
        return BigDecimal.ONE.divide(BigDecimal.valueOf(d), 10000, RoundingMode.HALF_UP);
    }

    protected String getRecurringCycle(BigDecimal d) {
        final String representation = d.toString();
        final StringBuilder cycle = new StringBuilder();
        final StringBuilder cycle2 = new StringBuilder();
        boolean afterDot = false;
        boolean cycleCollected = false;
        int cycleIndex = 0;
        int cycleProven = 0;
        for (char c : representation.toCharArray()) {
            if (!afterDot && c != '.') {
                continue;
            }
            if (c == '.') {
                afterDot = true;
                continue;
            }

            // we are after the dot - try to gather a recurring cycle
            if (cycleCollected) {
                if (cycleIndex >= cycle.length()) {
                    cycleProven++;
                    cycleIndex = 0;

                    if (cycleProven > 5) {
                        break;
                    }
                }
                if (cycle.toString().charAt(cycleIndex) == c) {
                    cycle2.append(c);
                    cycleIndex++;
                } else {
                    cycleCollected = false;
                    cycleIndex = 0;
                    cycle.append(cycle2);
                    cycle.append(c);
                    cycle2.setLength(0);
                }
            } else {
                if (cycle.length() > 0) {
                	// test for infinite recurring digit, e.g. 0.1666666...
                	int recurringDigit = 0;
                	for (char cycleDigit : cycle.toString().toCharArray()) {
                		if (cycleDigit == c) {
                			recurringDigit++;
                		} else {
                			recurringDigit = 0;
                		}
                		if (recurringDigit > 10) {
                			cycle.setLength(0);
                			cycle.append(c);
                			break;
                		}
                	}

                	// test whether cycle is finished and starts again
                    if (cycle.toString().charAt(0) == c && c != '0') {
                        cycleCollected = true;
                        cycle2.append(c);
                        cycleIndex++;
                    } else if (cycle.length() > 1000) {
                        cycle.setLength(0);
                    }
                }
                if (!cycleCollected) {
                    if (cycle.length() > 0 || c != '0') {
                        cycle.append(c);
                    }
                }
            }

        }

        if (cycleProven > 5) {
            return cycle.toString();
        } else {
            return "";
        }
    }

}
