package de.olilo.euler.level2;

import java.util.ArrayList;
import java.util.List;

class Problem39IntegerRightTriangles {

    public int getMaxSolutionCountUntil(int end) {
        int maxCount = 0;
        int maxSum = 0;
        for (int i = 0; i <= end; i++) {
            int count = getPossibleSolutionsFor(i).size();
            if (count > maxCount) {
                maxCount = count;
                maxSum = i;
            }
        }
        return maxSum;
    }

    public List<GeometricTriangle> getPossibleSolutionsFor(int sum) {
        int c = sum / 2;
        int a = 1, b = sum - c - a;
        List<GeometricTriangle> results = new ArrayList<>();
        while (c >= sum / 3) {
            if (a >= b) {
                c--;
                a = 1;
                b = sum - a - c;
            }

            final GeometricTriangle triangle = new GeometricTriangle(a, b, c);
            if (triangle.isRightTriangle()) {
                results.add(triangle);
            }

            a++;
            b--;
        }
        return results;
    }

}
