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

package com.lazycece.algo.jzoffer.jz63_maxProfit;

/**
 * @author lazycece
 * @date 2022/7/14
 */
public class Jz63MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int no = 0;
        int have = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            no = Math.max(no, have + prices[i]);
            // 只能买卖一次
            have = Math.max(have, -prices[i]);
        }
        return no;
    }
}
