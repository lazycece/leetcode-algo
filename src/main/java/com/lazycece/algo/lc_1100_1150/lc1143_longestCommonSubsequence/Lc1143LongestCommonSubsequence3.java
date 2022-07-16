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
 * dp 空间优化
 * dp[i]
 * = dp[i-1]+1,
 * = max(dp[i],dp[i-1])
 *
 * @author lazycece
 * @date 2022/7/16
 */
public class Lc1143LongestCommonSubsequence3 {

    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text2.length() + 1];
        int res = 0;
        for (int i = 1; i <= text1.length(); i++) {
            //dp[i-1][j-1]
            int pre = dp[0];
            for (int j = 1; j <= text2.length(); j++) {
                int tmp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = pre + 1;
                    res = Math.max(res, dp[j]);
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                pre = tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc1143LongestCommonSubsequence3 lc = new Lc1143LongestCommonSubsequence3();
//        System.out.println(lc.longestCommonSubsequence("abcde", "ace"));
//        System.out.println(lc.longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr"));
        System.out.println(lc.longestCommonSubsequence("abcba", "abcbcba"));
    }
}
