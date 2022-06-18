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
 * @author lazycece
 * @date 2022/6/17
 */
public class Lc28ImplementStrstr {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char[] a1 = haystack.toCharArray();
        char[] a2 = needle.toCharArray();
        int i = 0;
        while (i < a1.length) {
            int j = 0;
            int t = i;
            while (i < a1.length && j < a2.length) {
                if (a1[i] == a2[j]) {
                    i++;
                    j++;
                } else {
                    break;
                }
            }
            if (j == a2.length) {
                return t;
            }
            i = t + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Lc28ImplementStrstr lc = new Lc28ImplementStrstr();
        System.out.println(lc.strStr("hello", "ll"));
        System.out.println(lc.strStr("hell", "ll"));
        System.out.println(lc.strStr("hello", "he"));
        System.out.println(lc.strStr("aaaaa", "bba"));
        System.out.println(lc.strStr("aaaaa", ""));
        System.out.println(lc.strStr("mississippi", "issipi"));

    }
}
