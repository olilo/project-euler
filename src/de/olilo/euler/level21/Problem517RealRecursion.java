package de.olilo.euler.level21;

import de.olilo.util.LFUCache;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem517RealRecursion {

    public BigInteger G(int n) {
        return new FunctionG(Math.sqrt(n)).apply(n);
    }

    private class FunctionG {

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
            System.out.println(cache.size());
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
