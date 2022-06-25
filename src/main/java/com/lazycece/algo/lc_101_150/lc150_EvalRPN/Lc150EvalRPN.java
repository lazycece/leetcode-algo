/*
 *    Copyright 2022 lazycece<lazycece@gmail.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.lazycece.algo.lc_101_150.lc150_EvalRPN;

import java.util.Stack;

/**
 * @author lazycece
 * @date 2022/6/24
 */
public class Lc150EvalRPN {

    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (match(tokens[i])) {
                if (stack.size() < 2) {
                    throw new RuntimeException("error");
                }
                int b = stack.pop();
                int a = stack.pop();
                stack.add(calculate(a, b, tokens[i]));
            } else {
                stack.add(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    private boolean match(String str) {
        switch (str) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:
                return false;
        }
    }

    private Integer calculate(Integer a, Integer b, String operate) {
        switch (operate) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        throw new RuntimeException("exception");
    }

    public static void main(String[] args) {
        Lc150EvalRPN lc = new Lc150EvalRPN();
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println(lc.evalRPN(tokens1));
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(lc.evalRPN(tokens2));
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(lc.evalRPN(tokens3));

    }

}
