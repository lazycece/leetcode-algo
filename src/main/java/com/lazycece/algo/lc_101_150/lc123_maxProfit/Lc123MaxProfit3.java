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

package com.lazycece.algo.lc_101_150.lc123_maxProfit;

/**
 * dp 两次持有状态记录演进
 *
 * @author lazycece
 * @date 2022/7/14
 */
public class Lc123MaxProfit3 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][][] dp = new int[n][3][2];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= 2; k++) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = 0 - prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        //  return dp[n-1][2][0];
        return Math.max(dp[n - 1][1][0], dp[n - 1][2][0]);
    }

    public static void main(String[] args) {
        Lc123MaxProfit3 lc = new Lc123MaxProfit3();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(lc.maxProfit(prices));
    }
}
