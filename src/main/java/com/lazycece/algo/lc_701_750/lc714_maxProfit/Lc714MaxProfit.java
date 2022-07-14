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

package com.lazycece.algo.lc_701_750.lc714_maxProfit;

/**
 * @author lazycece
 * @date 2022/7/14
 */
public class Lc714MaxProfit {

    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;// 未持有
        dp[0][1] = -prices[0];// 持有
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        Lc714MaxProfit lc = new Lc714MaxProfit();
//        int[] prices = {1, 3, 2, 8, 4, 9};
//        int fee = 2;

        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        System.out.println(lc.maxProfit(prices, fee));
    }
}
