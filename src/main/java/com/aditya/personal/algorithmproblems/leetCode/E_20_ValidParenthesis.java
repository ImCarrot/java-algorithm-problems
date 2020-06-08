package com.aditya.personal.algorithmproblems.leetCode;

import java.util.Stack;

public class E_20_ValidParenthesis {

    public boolean isValid(String s) {

        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[')
                brackets.push(c);
            else {

                if (brackets.isEmpty())
                    return false;

                char opening = brackets.pop();

                if (c == ')' && opening != '(')
                    return false;
                else if (c == ']' && opening != '[')
                    return false;
                else if (c == '}' && opening != '{')
                    return false;
            }
        }

        return brackets.isEmpty();
    }

}
