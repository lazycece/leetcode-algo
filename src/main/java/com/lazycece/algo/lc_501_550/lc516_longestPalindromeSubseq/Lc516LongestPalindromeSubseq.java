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

package com.lazycece.algo.lc_501_550.lc516_longestPalindromeSubseq;

/**
 * 反转字符串，转换为两个字符串的最长公共子序列问题
 *
 * @author lazycece
 * @date 2022/7/16
 */
public class Lc516LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        String t = reverse(s);
        int[][] dp = new int[t.length() + 1][t.length() + 1];
        int res = 0;
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return res;
    }

    private String reverse(String s) {
        char[] ch = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char t = ch[l];
            ch[l++] = ch[r];
            ch[r--] = t;
        }
        return new String(ch);
    }
}
