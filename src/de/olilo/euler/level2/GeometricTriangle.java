package de.olilo.euler.level2;

public class GeometricTriangle {
    private int a;
    private int b;
    private int c;

    public GeometricTriangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isRightTriangle() {
        return Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeometricTriangle triangle = (GeometricTriangle) o;

        return a == triangle.a && b == triangle.b && c == triangle.c;

    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }

    @Override
    public String toString() {
        return "GeometricTriangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
