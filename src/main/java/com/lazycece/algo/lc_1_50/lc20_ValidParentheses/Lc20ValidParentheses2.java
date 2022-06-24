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

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lazycece
 * @date 2022/6/24
 */
public class Lc20ValidParentheses2 {
    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('{', 1);
        map.put('}', -1);
        map.put('(', 2);
        map.put(')', -2);
        map.put('[', 3);
        map.put(']', -3);

    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch : chs) {
            if (stack.size() == 0) {
                stack.push(ch);
                continue;
            }
            if (map.get(stack.peek()) + map.get(ch) == 0) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Lc20ValidParentheses2 lc = new Lc20ValidParentheses2();
        System.out.println(lc.isValid("()"));
        System.out.println(lc.isValid("()[]{}"));
        System.out.println(lc.isValid("(]"));
        System.out.println(lc.isValid("([)]"));
        System.out.println(lc.isValid("{[]}"));

    }
}
