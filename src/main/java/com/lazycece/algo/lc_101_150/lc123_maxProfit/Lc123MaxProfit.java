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
 *  dp 两次持有状态记录演进
 *
 * @author lazycece
 * @date 2022/7/14
 */
public class Lc123MaxProfit {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = 0; // 1未持有
        dp[0][1] = -prices[0]; // 1持有
        dp[0][2] = 0;// 2未持有
        dp[0][3] = -prices[0]; // 2持有
        for (int i = 1; i < prices.length; i++) {
            // 第一次持有 = max（第一次持有继续，今天买入持有）
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            // 第一次未持有 = max（第一次未持有继续，第一次持有了今天卖出）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 第二次持有 = max（第二次持有继续，第一次持有结束今天买入）
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][0] - prices[i]);
            // 第二次未持有 = max（第二次未持有继续，第二次持有今天卖出）
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][3] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }

    public static void main(String[] args) {
        Lc123MaxProfit lc = new Lc123MaxProfit();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(lc.maxProfit(prices));
    }
}
