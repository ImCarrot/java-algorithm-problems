package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Stack;

public class M_150_EvaluateReversePolishNotation {

    private int evaluate(String left, String right, String operator) {

        if (operator.equals("+"))
            return Integer.parseInt(left) + Integer.parseInt(right);

        if (operator.equals("-"))
            return Integer.parseInt(left) - Integer.parseInt(right);

        if (operator.equals("*"))
            return Integer.parseInt(left) * Integer.parseInt(right);

        if (operator.equals("/"))
            return Integer.parseInt(left) / Integer.parseInt(right);

        throw new UnsupportedOperationException( operator + " operator is not supported.");

    }

    public int evalRPN(String[] tokens) {

        Stack<String> processStack = new Stack<>();

        for (String token: tokens) {

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {

                String right = processStack.pop();
                String left = processStack.pop();

                int result = evaluate(left, right, token);

                processStack.push(String.valueOf(result));

            } else
                processStack.push(token);

        }

        if (processStack.isEmpty())
            return 0;

        return Integer.parseInt(processStack.pop());
    }

}
