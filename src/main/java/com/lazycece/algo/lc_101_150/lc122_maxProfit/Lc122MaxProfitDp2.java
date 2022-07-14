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

package com.lazycece.algo.lc_101_150.lc122_maxProfit;

/**
 * @author lazycece
 * @date 2022/7/14
 */
public class Lc122MaxProfitDp2 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int[][] dp = new int[prices.length][2];

        int hold = -prices[0]; //持有
        int unhold = 0;// 未持有

        for (int i = 1; i < prices.length; i++) {
            int h = Math.max(hold, unhold - prices[i]);
            int un = Math.max(unhold, hold + prices[i]);
            hold = h;
            unhold = un;
        }
        return unhold;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Lc122MaxProfitDp2 lc = new Lc122MaxProfitDp2();
        System.out.println(lc.maxProfit(prices));
    }
}
