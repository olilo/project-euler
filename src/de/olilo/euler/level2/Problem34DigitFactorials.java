package de.olilo.euler.level2;

class Problem34DigitFactorials {

    public long sumOfDigitFactorialsUntil(int limit) {
        int sum = 0;
        for (int i = 10; i < limit; i++) {
            if (isDigitFactorial(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public long factorialOf(int number) {
        long result = 1;
        while (number > 1) {
            result *= number--;
        }
        return result;
    }

    public boolean isDigitFactorial(int number) {
        int result = 0;
        for (char digit : Integer.toString(number).toCharArray()) {
            result += factorialOf(new Integer(digit + ""));
        }
        return result == number;
    }

}
