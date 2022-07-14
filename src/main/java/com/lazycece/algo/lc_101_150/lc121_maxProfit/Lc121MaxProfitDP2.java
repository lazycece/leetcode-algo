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

package com.lazycece.algo.lc_101_150.lc121_maxProfit;

/**
 * 动态规划
 * 推导公式：
 *  f(n) = max(f(n-1),prices[n]-min(price[0],.....,price[n-1]))
 *
 *
 * @author lazycece
 * @date 2022/7/13
 */
public class Lc121MaxProfitDP2 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int unhold = 0, hold = 0 - prices[0];
        for (int i = 1; i < prices.length; i++) {
            unhold = Math.max(unhold, hold + prices[i]);
            // -price[i] 表示只买入一次
            // unhold - price[i] 表示可以买入n次，即无限次
            hold = Math.max(hold, 0 - prices[i]);
        }
        return unhold;
    }

    public static void main(String[] args) {
        Lc121MaxProfitDP2 lc = new Lc121MaxProfitDP2();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(lc.maxProfit(prices));

    }
}
