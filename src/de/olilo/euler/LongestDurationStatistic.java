package de.olilo.euler;

class LongestDurationStatistic {

    long duration = 0;
    int index = 0;

    LongestDurationStatistic() {
    }

    LongestDurationStatistic(long duration, int index) {
        this.duration = duration;
        this.index = index;
    }

    public void checkAndUpdate(long duration, int index) {
        if (duration > this.duration) {
            this.duration = duration;
            this.index = index;
        }
    }

    long getDuration() {
        return duration;
    }

    int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LongestDurationStatistic statistic = (LongestDurationStatistic) o;

        return duration == statistic.duration && index == statistic.index;

    }

    @Override
    public int hashCode() {
        int result = (int) (duration ^ (duration >>> 32));
        result = 31 * result + index;
        return result;
    }

}
