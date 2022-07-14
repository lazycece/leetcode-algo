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

package com.lazycece.algo.lc_151_200.lc188_maxProfit;

/**
 * @author lazycece
 * @date 2022/7/14
 */
public class Lc188MaxProfit2 {

    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        // dp[i][k][0] k次卖出，即未持有
        // dp[i][k][0] k次买入，即持有
        int[][][] dp = new int[prices.length][k + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }

    public static void main(String[] args) {
        Lc188MaxProfit2 lc = new Lc188MaxProfit2();
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        System.out.println(lc.maxProfit(k, prices));
    }
}
