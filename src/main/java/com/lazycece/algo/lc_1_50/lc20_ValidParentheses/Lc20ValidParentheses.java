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

package com.lazycece.algo.lc_1_50.lc20_ValidParentheses;

import java.util.Stack;

/**
 * @author lazycece
 * @date 2022/6/24
 */
public class Lc20ValidParentheses {

    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (stack.empty()) {
                stack.add(ch[i]);
            } else {
                char t = stack.peek();
                if (match(t, ch[i])) {
                    stack.pop();
                } else {
                    stack.add(ch[i]);
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean match(char l, char r) {
        if (l == '(' && r == ')') {
            return true;
        }
        if (l == '[' && r == ']') {
            return true;
        }
        if (l == '{' && r == '}') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Lc20ValidParentheses lc = new Lc20ValidParentheses();
        System.out.println(lc.isValid("()"));
        System.out.println(lc.isValid("()[]{}"));
        System.out.println(lc.isValid("(]"));
        System.out.println(lc.isValid("([)]"));
        System.out.println(lc.isValid("{[]}"));

    }
}
