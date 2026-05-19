package de.olilo.euler.level2;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Problem39IntegerRightTriangles implements Problem {

    @Override
    public String getMessage() {
        return "The value of p <= 1000 for which the number of right triangle solutions is maximised is: ";
    }

    @Override
    public int getProblemNumber() {
        return 39;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        return getMaxSolutionCountUntil(1000);
    }

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
