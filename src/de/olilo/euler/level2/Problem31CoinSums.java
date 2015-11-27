package de.olilo.euler.level2;

import java.util.ArrayList;
import java.util.List;

class Problem31CoinSums {

    public List<Coins> getPossibleSolutionsFor(int sum) {
        // wrapped ArrayList that "forgets" everything after the 1000th result
        // this ensures that tests can verify the correctness,
        // and outside applications can just query the size without polluting the heap
        final List<Coins> result = new ArrayList<Coins>() {
            int additionalCount = 0;

            @Override
            public boolean add(Coins coins) {
                if (super.size() < 1000) {
                    return super.add(coins);
                } else {
                    additionalCount++;
                    return true;
                }
            }

            @Override
            public int size() {
                return super.size() + additionalCount;
            }
        };
        Coins coins = new Coins();
        coins.setAmount1p(sum);
        while (true) {
            assert coins.getTotalFrom(CoinType.AMOUNT1P) == sum;
            result.add(coins);
            coins = coins.copy();
            if (coins.getAmount1p() >= 2) {
                coins.setAmount2p(coins.getAmount2p() + 1);
                coins.setAmount1p(coins.getAmount1p() - 2);
                continue;
            }
            if (sum - coins.getTotalFrom(CoinType.AMOUNT5P) >= 5) {
                coins.setAmount5p(coins.getAmount5p() + 1);
                coins.setAmount2p(0);
                coins.setAmount1p(sum - coins.getTotalFrom(CoinType.AMOUNT2P));
                continue;
            }
            if (sum - coins.getTotalFrom(CoinType.AMOUNT10P) >= 10) {
                coins.setAmount10p(coins.getAmount10p() + 1);
                coins.setAmount5p(0);
                coins.setAmount2p(0);
                coins.setAmount1p(sum - coins.getTotalFrom(CoinType.AMOUNT2P));
                continue;
            }
            if (sum - coins.getTotalFrom(CoinType.AMOUNT20P) >= 20) {
                coins.setAmount20p(coins.getAmount20p() + 1);
                coins.setAmount10p(0);
                coins.setAmount5p(0);
                coins.setAmount2p(0);
                coins.setAmount1p(sum - coins.getTotalFrom(CoinType.AMOUNT2P));
                continue;
            }
            if (sum - coins.getTotalFrom(CoinType.AMOUNT50P) >= 50) {
                coins.setAmount50p(coins.getAmount50p() + 1);
                coins.setAmount20p(0);
                coins.setAmount10p(0);
                coins.setAmount5p(0);
                coins.setAmount2p(0);
                coins.setAmount1p(sum - coins.getTotalFrom(CoinType.AMOUNT2P));
                continue;
            }
            if (sum - coins.getTotalFrom(CoinType.AMOUNT100P) >= 100) {
                coins.setAmount100p(coins.getAmount100p() + 1);
                coins.setAmount50p(0);
                coins.setAmount20p(0);
                coins.setAmount10p(0);
                coins.setAmount5p(0);
                coins.setAmount2p(0);
                coins.setAmount1p(sum - coins.getTotalFrom(CoinType.AMOUNT2P));
                continue;
            }
            if (sum - coins.getTotalFrom(CoinType.AMOUNT200P) >= 200) {
                coins.setAmount200p(coins.getAmount200p() + 1);
                coins.setAmount100p(0);
                coins.setAmount50p(0);
                coins.setAmount20p(0);
                coins.setAmount10p(0);
                coins.setAmount5p(0);
                coins.setAmount2p(0);
                coins.setAmount1p(sum - coins.getTotalFrom(CoinType.AMOUNT2P));
            } else {
                break;
            }
        }
        return result;
    }

}
