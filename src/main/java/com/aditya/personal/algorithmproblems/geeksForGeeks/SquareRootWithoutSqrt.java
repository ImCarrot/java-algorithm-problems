package com.aditya.personal.algorithmproblems.geeksForGeeks;

public class SquareRootWithoutSqrt {

    public static double sqrt(int number) {

        if (number == 0 || number == 1)
            return number;

        double beforeDecimal = 0;

        for (int i = 2; i * i <= number; i++) {

            if (i * i == number)
                return i;

            beforeDecimal = i;
        }


        double step = 0.1;
        while (beforeDecimal * beforeDecimal != number) {

            double newValue = beforeDecimal + step;

            double newSquare = newValue * newValue;

            double diff = number - newSquare;

            if (diff == 0 || Math.abs(diff) < 0.00001)
                return newValue;

            if (newSquare > number) {
                step = step / 10;
                continue;
            }

            beforeDecimal = newValue;
        }

        return beforeDecimal;
    }

    static double squareRootViaBinary(double n, double i, double j) {
        double mid = (i + j) / 2;
        double mul = mid * mid;

        if ((mul == n) || (Math.abs(mul - n) < 0.00001))
            return mid;

        else if (mul < n)
            return squareRootViaBinary(n, mid, j);

        else
            return squareRootViaBinary(n, i, mid);
    }

    static double findSqrt(double n) {

        double i = 1;

        boolean found = false;

        while (!found) {

            // If n is a perfect square
            if (i * i == n) {
                System.out.println(i);
                found = true;
            } else if (i * i > n) {

                // Square root will lie in the
                // interval i-1 and i
                return squareRootViaBinary(n, i - 1, i);
            }
            i++;
        }
        return -1;
    }


    public static void main(String[] args) {
        int number = 2;
        System.out.println(sqrt(number));
        System.out.println(findSqrt(number));
        System.out.println(Math.sqrt(number));
    }
}
