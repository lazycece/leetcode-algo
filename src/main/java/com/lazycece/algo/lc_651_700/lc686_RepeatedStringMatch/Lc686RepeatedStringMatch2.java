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

package com.lazycece.algo.lc_651_700.lc686_RepeatedStringMatch;

/**
 * @author lazycece
 * @date 2022/6/24
 */
public class Lc686RepeatedStringMatch2 {
    public int repeatedStringMatch(String a, String b) {
        int an = a.length(), bn = b.length();
        int index = instr(a, b);
        if (index == -1) {
            return -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }

    private int instr(String a, String b) {
        int an = a.length(), bn = b.length();
        int[] next = new int[bn];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < bn; i++) {
            while (j > 0 && b.charAt(i) != b.charAt(j)) {
                j = next[j - 1];
            }
            if (b.charAt(i) == b.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        j = 0;
        for (int i = 0; i - j < an; i++) {
            while (j > 0 && a.charAt(i % an) != b.charAt(j)) {
                j = next[j - 1];
            }
            if (a.charAt(i % an) == b.charAt(j)) {
                j++;
            }
            if (j == bn) {
                return i - bn + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Lc686RepeatedStringMatch2 lc = new Lc686RepeatedStringMatch2();
        System.out.println(lc.repeatedStringMatch("abcd", "cdabcdab"));
    }
}
