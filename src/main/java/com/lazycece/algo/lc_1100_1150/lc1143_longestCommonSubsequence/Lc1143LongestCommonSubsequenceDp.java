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

package com.lazycece.algo.lc_1100_1150.lc1143_longestCommonSubsequence;

/**
 * dp[i][j] = dp[i-1][j-1] +1 , a[i]==b[j]
 * = max(dp[i-1][j],dp[i][j-1) ,a[i]!=b[j]
 *
 * @author lazycece
 * @date 2022/7/16
 */
public class Lc1143LongestCommonSubsequenceDp {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        int res = 0;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (j == 0 || i == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                } else {
                    if (j == 0 && i == 0) dp[i][j] = 0;
                    else if (j == 0) dp[i][j] = dp[i - 1][j];
                    else if (i == 0) dp[i][j] = dp[i][j - 1];
                    else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc1143LongestCommonSubsequenceDp lc = new Lc1143LongestCommonSubsequenceDp();
        System.out.println(lc.longestCommonSubsequence("abcde", "ace"));
    }
}
