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

package com.lazycece.algo.lc_301_350.lc322_coinChange;

import java.util.Arrays;

/**
 * 记忆化搜索, 空间换减枝
 *
 * @author lazycece
 * @date 2022/8/23
 */
public class Lc322CoinChange3 {
    int[] cache;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        cache = new int[amount + 1];
        int res = dfs(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) return -1;

        if (cache[amount] != 0) {
            return cache[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int cnt = dfs(coins, amount - coins[i]);
            if (cnt >= 0 && cnt < min) {
                min = cnt + 1;
            }
        }
        cache[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return cache[amount];
    }

    public static void main(String[] args) {
        Lc322CoinChange3 lc = new Lc322CoinChange3();
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        System.out.println(lc.coinChange(coins, amount));
    }
}
