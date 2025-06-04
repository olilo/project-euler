package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.Numbers;
import de.olilo.util.PrimesIterable;

public class Problem46GoldbachsOtherConjecture implements Problem {

    @Override
    public String getMessage() {
        return "The smallest odd composite that cannot be written as the sum of a prime and twice a square is: ";
    }

    @Override
    public int getProblemNumber() {
        return 46;
    }

    @Override
    public Number runProblem(Runner runner) {
        for (int i = 9;; i += 2) {
            if (Numbers.isComposite(i) && isNotWritableAsPrimeAndTwiceSquare(i)) {
                return i;
            }
        }
    }

    protected boolean isNotWritableAsPrimeAndTwiceSquare(int n) {
        for (int i : PrimesIterable.INSTANCE) {
            if (i > n) {
                return true;
            }

            if (Numbers.isSquareNumber((n - i) / 2)) {
                return false;
            }
        }

        return true;
    }

}
