package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;
import de.olilo.util.PrimesIterable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Problem50ConsecutivePrimeSum implements Problem {

    @Override
    public String getMessage() {
        return "The prime, below one-million, which can be written as the sum of the most consecutive primes is: ";
    }

    @Override
    public int getProblemNumber() {
        return 50;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return findPrimeAddingToLongestPrimeSequenceBelow(1_000_000);
    }

    protected int findPrimeAddingToLongestPrimeSequenceBelow(int limit) {
        // 1. Alle benötigten Primzahlen einmalig sammeln
        final List<Integer> primes = new ArrayList<>();
        for (int prime : PrimesIterable.INSTANCE) {
            if (prime >= limit) break;
            primes.add(prime);
        }

        // 2. Präfixsummen berechnen — O(n), einmalig
        int n = primes.size();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + primes.get(i);
        }

        // 3. Sliding Window: alle Fenster mit prime-Summe < limit prüfen
        int bestLength = 0;
        int bestPrime  = 0;

        for (int i = 0; i < n; i++) {
            // j startet ab bekannter Mindestlänge
            for (int j = i + bestLength + 1; j <= n; j++) {
                int sum = prefix[j] - prefix[i];

                // wenn Fenster zu groß → nächstes i
                if (sum >= limit) {
                    break;
                }

                // teste ob aktuelles Fenster (i bis j) länger als das bisher beste Fenster ist und
                // zu einer Primzahl addiert
                int length = j - i;
                if (length > bestLength && primes.contains(sum)) {
                    bestLength = length;
                    bestPrime  = sum;
                }
            }
        }

        return bestPrime;
    }

}
