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

package com.lazycece.algo.lc_601_650.lc647_countSubstrings;

/**
 * @author lazycece
 * @date 2022/7/16
 */
public class Lc647CountSubstrings {
    private boolean[][] dp;

    public int countSubstrings(String s) {
        dp = new boolean[s.length() + 1][s.length() + 1];
        int res = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if (helper(s, i - 1, j - 1)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean helper(String s, int l, int r) {
        if (l > r) return true;
        if (dp[l + 1][r + 1]) return true;
        boolean res = false;
        if (s.charAt(l) != s.charAt(r)) {
            res = false;
        } else {
            res = helper(s, l + 1, r - 1);
        }
        dp[l + 1][r + 1] = res;
        return res;
    }

    public static void main(String[] args) {
        Lc647CountSubstrings lc = new Lc647CountSubstrings();
        System.out.println(lc.countSubstrings("abc"));
    }
}
