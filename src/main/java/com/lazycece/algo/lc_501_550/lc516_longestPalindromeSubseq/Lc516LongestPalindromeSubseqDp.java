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
 * dp[i][j]
 * = dp[i+1][j-1] +2, if a[i]==a[j]
 * = max(dp[i][j-1], dp[i+1][j]), if a[i]!=a[j]
 * 由于[i+1][j-1] 可以看出, dp是从矩阵的左下角推导出来的,
 *
 * @author lazycece
 * @date 2022/7/16
 */
public class Lc516LongestPalindromeSubseqDp {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) dp[i][j] = 2;
                    else if (j - i == 2) dp[i][j] = 3;
                    else dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
