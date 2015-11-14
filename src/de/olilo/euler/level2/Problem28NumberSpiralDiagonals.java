package de.olilo.euler.level2;

public class Problem28NumberSpiralDiagonals {

    public int getNumberSpiralDiagonalsFor(int size) {
        int length = (size - 1) / 2;
        // 1
        // 1 + 2 = 3; 1 + 2*2 + 1*8 = 13; 1 + 3*2 + 3*8 = 31; 1 + 4*2 + 6*8 = 56 ...
        // 1 + 4; 1 + 2*4 + 1*8; ...
        // 1 + 6; 1 + 2*6 + 1*8; ...
        // 1 + 8; 1 + 2*8 + 1*8; ...
        int result = 1;
        result += length + 2 * (length + 1) * (length) / 2;
        result += length + 4 * (length + 1) * (length) / 2;
        result += length + 6 * (length + 1) * (length) / 2;
        result += length + 8 * (length + 1) * (length) / 2;
        for (int i = 0; i < length; i++) {
            result += 4 * 8 * (i * (i + 1)) / 2;
        }
        return result;
    }

}
