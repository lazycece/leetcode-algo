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

package com.lazycece.algo.lc5_LongestPalindromicSubstring;

/**
 * 中心扩张法
 *
 * @author lazycece
 * @date 2022/2/28
 */
public class Lc5LongestPalindromicSubstring {

    private int left = 0;
    private int right = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            helper(ch, i, i);
            helper(ch, i, i + 1);
        }
        return s.substring(left, right + 1);
    }

    private void helper(char[] ch, int l, int r) {
        while (l >= 0 && r < ch.length && ch[l] == ch[r]) {
            l--;
            r++;
        }
        l++;
        r--;
        if (r - l > right - left) {
            right = r;
            left = l;
        }
    }

    public static void main(String[] args) {
        Lc5LongestPalindromicSubstring lc5 = new Lc5LongestPalindromicSubstring();
        System.out.println(lc5.longestPalindrome("a"));
        System.out.println(lc5.longestPalindrome("cbbd"));
//        System.out.println(lc5.longestPalindrome("babad"));
//        System.out.println(lc5.longestPalindrome("abcdcba"));
//        System.out.println(lc5.longestPalindrome(""));
    }
}
