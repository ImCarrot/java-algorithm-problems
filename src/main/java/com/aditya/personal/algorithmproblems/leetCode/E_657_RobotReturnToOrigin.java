package com.aditya.personal.algorithmproblems.leetCode;

public class E_657_RobotReturnToOrigin {

    public static boolean judgeCircle(String moves) {

        if (moves == null || moves.trim().isEmpty())
            return true;

        int upDownCounter = 0;
        int leftRightCounter = 0;

        for (char c : moves.toCharArray()) {

            if (c == 'U')
                upDownCounter++;
            else if (c == 'D')
                upDownCounter--;
            else if (c == 'R')
                leftRightCounter++;
            else if (c == 'L')
                leftRightCounter--;
        }

        return upDownCounter == 0 && leftRightCounter == 0;
    }

    public static void main(String[] args) {
        boolean output = judgeCircle("UD"); // True
        System.out.println(output);

        output = judgeCircle("LL"); // false;
        System.out.println(output);
    }

}
