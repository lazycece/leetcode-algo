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

package com.lazycece.algo.lc_451_500.lc459_RepeatedSubstringPattern;

/**
 * @author lazycece
 * @date 2022/6/23
 */
public class Lc459RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        // kmp算法
        char[] arr = s.toCharArray();
        int[] next = new int[arr.length];
        next[0] = 0;
        int j = 0;
        // abab
        for (int i = 1; i < arr.length; i++) {
            while (j > 0 && arr[i] != arr[j]) {
                j = next[j - 1];
            }
            if (arr[i] == arr[j]) {
                j++;
            }
            next[i] = j;
        }
        int len = arr.length;
        return next[len - 1] > 0 && (len % (len - next[len - 1])) == 0;
    }

    public static void main(String[] args) {
        Lc459RepeatedSubstringPattern lc = new Lc459RepeatedSubstringPattern();
        System.out.println(lc.repeatedSubstringPattern("abab"));
        System.out.println(lc.repeatedSubstringPattern("aba"));
        System.out.println(lc.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(lc.repeatedSubstringPattern("abac"));
    }
}
