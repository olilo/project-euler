package de.olilo.euler.level1;

public class Problem14CollatzSequence {

    public int findLongestSequenceUnder(int limit) {
        // make a buffer of the found lengths at each int value
        int[] lengths = new int[limit];
        for (int i = 1; i < limit; i++) {
            lengths[i] = getCollatzLength(lengths, i);
        }

        int max = 0;
        int maxId = 0;
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] > max) {
                maxId = i;
                max = lengths[i];
            }
        }
        return maxId;
    }

    int getCollatzLength(int[] lengths, int i) {
        int length = 1;
        long current = i;
        while (current != 1) {
            // check whether we already have a length
            if (current < lengths.length && lengths[(int) current] > 0) {
                length += lengths[(int) current] - 1;
                break;
            } else {
                length++;
            }

            if (current % 2 == 0) {
                current /= 2;
            } else {
                current = 3 * current + 1;
            }
        }
        return length;
    }

}
