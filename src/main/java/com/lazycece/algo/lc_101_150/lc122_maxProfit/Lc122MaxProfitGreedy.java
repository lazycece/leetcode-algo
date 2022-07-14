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
public class Lc122MaxProfitGreedy {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int num = 0;
        for (int i = 1; i < prices.length; i++) {
            int gap = prices[i] - prices[i - 1];
            if (gap > 0) num += gap;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Lc122MaxProfitGreedy lc = new Lc122MaxProfitGreedy();
        System.out.println(lc.maxProfit(prices));
    }
}
