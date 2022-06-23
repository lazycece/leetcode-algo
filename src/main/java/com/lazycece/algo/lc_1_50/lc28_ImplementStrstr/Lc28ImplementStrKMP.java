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

package com.lazycece.algo.lc_1_50.lc28_ImplementStrstr;

/**
 * KMP 算法
 *
 * @author lazycece
 * @date 2022/6/17
 */
public class Lc28ImplementStrKMP {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char[] a1 = haystack.toCharArray();
        char[] a2 = needle.toCharArray();
        int[] next = getNext(a2);

        int j = 0;
        for (int i = 0; i < a1.length; i++) {
            while (j > 0 && a1[i] != a2[j]) {
                j = next[j - 1];
            }
            if (a1[i] == a2[j]) {
                j++;
            }
            if (j == a2.length) {
                return i - a2.length + 1;
            }
        }
        return -1;
    }

    // aabaabaafa | aabaaf
    private int[] getNext(char[] arr) {
        // 动态规划求next数组
        int[] next = new int[arr.length];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            while (j > 0 && arr[i] != arr[j]) {
                j = next[j - 1];
            }
            if (arr[i] == arr[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    public static void main(String[] args) {
        Lc28ImplementStrKMP lc = new Lc28ImplementStrKMP();
        System.out.println(lc.strStr("hello", "ll"));
        System.out.println(lc.strStr("hell", "ll"));
        System.out.println(lc.strStr("hello", "he"));
        System.out.println(lc.strStr("aaaaa", "bba"));
        System.out.println(lc.strStr("aaaaa", ""));
        System.out.println(lc.strStr("mississippi", "issip"));
        System.out.println(lc.strStr("aabaabaafa", "aabaaf"));
    }
}
