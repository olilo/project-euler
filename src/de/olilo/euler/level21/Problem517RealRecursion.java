package de.olilo.euler.level21;

import de.olilo.euler.Draft;
import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.PrimesIterable;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Draft
public class Problem517RealRecursion implements Problem {

    public BigInteger G(int n) {
        return new FunctionG(Math.sqrt(n)).apply(n);
    }

    @Override
    public String getMessage() {
        return "The sum of all G(p) where p is a prime number between 10_000_000 and 10_010_000 is: ";
    }

    @Override
    public int getProblemNumber() {
        return 517;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        BigInteger sum = BigInteger.ZERO;
        // naive approach runs too long and runs out of memory
        /*for (int i = 10_000_000; i < 10_010_000; i++) {
            if (PrimesIterable.INSTANCE.isPrime(i)) {
                sum = sum.add(new FunctionG(Math.sqrt(i)).apply(i));
            }
        }*/
        return sum.mod(BigInteger.valueOf(1_000_000_007));
    }

    private static class FunctionG {

        private final double a;
        private final Map<Double, BigInteger> cache = new HashMap<>();
        private final Stack<CalculationResult> resultStack = new Stack<>();

        FunctionG(double a) {
            this.a = a;
        }

        public BigInteger apply(double x) {
            resultStack.push(new CalculationResult(x));
            while (resultStack.peek().x > a + 500) {
                resultStack.peek().prepare();
            }

            BigInteger result = BigInteger.ZERO;
            while (!resultStack.isEmpty()) {
                result = resultStack.pop().getResult();
            }
            return result;
        }

        private class CalculationResult {
            private double x;

            public CalculationResult(double x) {
                this.x = x;
            }

            public void prepare() {
                if (!cache.containsKey((double) Math.round(x * 100)) && x >= a + 500) {
                    resultStack.push(new CalculationResult(x - a));
                    resultStack.push(new CalculationResult(x - 1));
                }
            }

            BigInteger apply(double x) {
                if (cache.containsKey((double) Math.round(x * 100))) {
                    return cache.get((double) Math.round(x * 100));
                }

                if (x < a) {
                    return BigInteger.ONE;
                } else {
                    final BigInteger result = apply(x - 1).add(apply(x - a));
                    cache.put((double) Math.round(x * 100), result);
                    return result;
                }
            }

            public BigInteger getResult() {
                if (cache.containsKey((double) Math.round(x * 100))) {
                    return cache.get((double) Math.round(x * 100));
                } else if (x < a) {
                    return BigInteger.ONE;
                } else {
                    return apply(x);
                }
            }
        }

    }

}
