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

package com.lazycece.algo.lc_1_50.lc17_letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lazycece
 * @date 2022/7/9
 */
public class Lc17LetterCombinations {

    private List<String> res = new ArrayList<>();
    private Map<Character, String> map = new HashMap<>();

    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {

        int n = digits.length();
        if (n == 0) return res;
        char[] arr = digits.toCharArray();
        helper(arr, 0, "");
        return res;
    }

    private void helper(char[] arr, int index, String s) {
        if (s.length() == arr.length) {
            res.add(s);
            return;
        }
        String str = map.get(arr[index]);
        char[] ch = str.toCharArray();
        for (int k = 0; k < ch.length; k++) {
            String t = s + ch[k];
            helper(arr, index + 1, t);
        }
    }

    public static void main(String[] args) {
        Lc17LetterCombinations lc = new Lc17LetterCombinations();
        System.out.println(lc.letterCombinations("23"));
    }
}
