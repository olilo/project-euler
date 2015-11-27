package de.olilo.euler.level2;

public class Coins {
    private int amount200p;
    private int amount100p;
    private int amount50p;
    private int amount20p;
    private int amount10p;
    private int amount5p;
    private int amount2p;
    private int amount1p;

    public Coins() {
    }

    public Coins(int amount200p, int amount100p, int amount50p, int amount20p, int amount10p, int amount5p, int amount2p, int amount1p) {
        this.amount200p = amount200p;
        this.amount100p = amount100p;
        this.amount50p = amount50p;
        this.amount20p = amount20p;
        this.amount10p = amount10p;
        this.amount5p = amount5p;
        this.amount2p = amount2p;
        this.amount1p = amount1p;
    }

    public Coins copy() {
        final Coins coins2 = new Coins();
        coins2.setAmount200p(getAmount200p());
        coins2.setAmount100p(getAmount100p());
        coins2.setAmount50p(getAmount50p());
        coins2.setAmount20p(getAmount20p());
        coins2.setAmount10p(getAmount10p());
        coins2.setAmount5p(getAmount5p());
        coins2.setAmount2p(getAmount2p());
        coins2.setAmount1p(getAmount1p());
        return coins2;
    }

    public int getTotalFrom(CoinType coinType) {
        int result = 0;
        if (coinType.ordinal() == 0) {
            result += amount1p;
        }
        if (coinType.ordinal() <= 1) {
            result += 2 * amount2p;
        }
        if (coinType.ordinal() <= 2) {
            result += 5 * amount5p;
        }
        if (coinType.ordinal() <= 3) {
            result += 10 * amount10p;
        }
        if (coinType.ordinal() <= 4) {
            result += 20 * amount20p;
        }
        if (coinType.ordinal() <= 5) {
            result += 50 * amount50p;
        }
        if (coinType.ordinal() <= 6) {
            result += 100 * amount100p;
        }
        if (coinType.ordinal() <= 7) {
            result += 200 * amount200p;
        }
        return result;
    }

    public int getAmount200p() {
        return amount200p;
    }

    public void setAmount200p(int amount200p) {
        this.amount200p = amount200p;
    }

    public int getAmount100p() {
        return amount100p;
    }

    public void setAmount100p(int amount100p) {
        this.amount100p = amount100p;
    }

    public int getAmount50p() {
        return amount50p;
    }

    public void setAmount50p(int amount50p) {
        this.amount50p = amount50p;
    }

    public int getAmount20p() {
        return amount20p;
    }

    public void setAmount20p(int amount20p) {
        this.amount20p = amount20p;
    }

    public int getAmount10p() {
        return amount10p;
    }

    public void setAmount10p(int amount10p) {
        this.amount10p = amount10p;
    }

    public int getAmount5p() {
        return amount5p;
    }

    public void setAmount5p(int amount5p) {
        this.amount5p = amount5p;
    }

    public int getAmount2p() {
        return amount2p;
    }

    public void setAmount2p(int amount2p) {
        this.amount2p = amount2p;
    }

    public int getAmount1p() {
        return amount1p;
    }

    public void setAmount1p(int amount1p) {
        this.amount1p = amount1p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coins coins = (Coins) o;

        if (amount200p != coins.amount200p) return false;
        if (amount100p != coins.amount100p) return false;
        if (amount50p != coins.amount50p) return false;
        if (amount20p != coins.amount20p) return false;
        if (amount10p != coins.amount10p) return false;
        if (amount5p != coins.amount5p) return false;
        //noinspection SimplifiableIfStatement
        if (amount2p != coins.amount2p) return false;
        return amount1p == coins.amount1p;

    }

    @Override
    public int hashCode() {
        int result = amount200p;
        result = 31 * result + amount100p;
        result = 31 * result + amount50p;
        result = 31 * result + amount20p;
        result = 31 * result + amount10p;
        result = 31 * result + amount5p;
        result = 31 * result + amount2p;
        result = 31 * result + amount1p;
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        if (amount200p > 0) result += amount200p + "x200p ";
        if (amount100p > 0) result += amount100p + "x100p ";
        if (amount50p > 0) result += amount50p + "x50p ";
        if (amount20p > 0) result += amount20p + "x20p ";
        if (amount10p > 0) result += amount10p + "x10p ";
        if (amount5p > 0) result += amount5p + "x5p ";
        if (amount2p > 0) result += amount2p + "x2p ";
        if (amount1p > 0) result += amount1p + "x1p ";
        return result.trim();
    }
}
