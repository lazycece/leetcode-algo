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
 * @author lazycece
 * @date 2022/8/23
 */
public class Lc322CoinChange {
    int cnt = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, amount, coins.length-1,0);
        return  cnt==Integer.MAX_VALUE?   -1:cnt;
    }

    private void dfs(int[] coins, int amount, int index,int count) {
        if (amount == 0) {
            cnt = Math.min(cnt,count);

        }
        if (amount < 0) return ;
        for (int i = index; i >=0; i--) {
            dfs(coins, amount - coins[i],i,count+1);
        }
    }

    public static void main(String[] args) {
        Lc322CoinChange lc  = new Lc322CoinChange();
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println(lc.coinChange(coins,amount));
    }
}
