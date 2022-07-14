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
public class Lc714MaxProfit2 {

    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) return 0;

        int no = 0;// 未持有
        int have = -prices[0];// 持有
        for (int i = 1; i < prices.length; i++) {
            int n = Math.max(no, have + prices[i] - fee);
            int h = Math.max(have, no - prices[i]);
            no = n;
            have = h;
        }
        return no;
    }

    public static void main(String[] args) {
        Lc714MaxProfit2 lc = new Lc714MaxProfit2();
//        int[] prices = {1, 3, 2, 8, 4, 9};
//        int fee = 2;

        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        System.out.println(lc.maxProfit(prices, fee));
    }
}
