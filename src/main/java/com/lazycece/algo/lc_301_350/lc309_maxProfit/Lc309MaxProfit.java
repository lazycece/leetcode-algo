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

package com.lazycece.algo.lc_301_350.lc309_maxProfit;

/**
 * @author lazycece
 * @date 2022/7/14
 */
public class Lc309MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;// 未持有
        dp[0][1] = -prices[0];// 持有
        dp[1][0] = Math.max(0, dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            //  非持有 = max（前一天的非持有继续，前一次持有今天卖出）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //  持有 = max（前一天的持有继续，前一天冻结（即前一天的前一天卖出）今天买入）
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        Lc309MaxProfit lc = new Lc309MaxProfit();
//        int[] prices = {1, 2, 3, 0, 2};
        int[] prices = {1};
        System.out.println(lc.maxProfit(prices));
    }
}
//