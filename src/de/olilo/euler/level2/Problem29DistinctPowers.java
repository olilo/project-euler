package de.olilo.euler.level2;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

class Problem29DistinctPowers {

    public Set<BigDecimal> getDistinctPowersOf2To(int a, int b) {
        final Set<BigDecimal> result = new HashSet<>();
        for (int i = 2; i <= a; i++) {
            for (int j = 2; j <= b; j++) {
                result.add(BigDecimal.valueOf(i).pow(j));
            }
        }
        return result;
    }
}
