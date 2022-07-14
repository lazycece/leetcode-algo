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
 * - 第i天卖出的收益：f(i) = prices[i] - min(prices[0],...., prices[i-1])
 * - 不能在同一天卖出, 初始化 min = prices[0]
 *
 * @author lazycece
 * @date 2022/7/13
 */
public class Lc121MaxProfitDP {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i] - min, max);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Lc121MaxProfitDP lc = new Lc121MaxProfitDP();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(lc.maxProfit(prices));

    }
}
