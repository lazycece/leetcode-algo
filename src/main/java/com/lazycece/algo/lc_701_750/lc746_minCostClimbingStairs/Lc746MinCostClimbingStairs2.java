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

package com.lazycece.algo.lc_701_750.lc746_minCostClimbingStairs;

/**
 * @author lazycece
 * @date 2022/7/6
 */
public class Lc746MinCostClimbingStairs2 {

    public int minCostClimbingStairs(int[] cost) {
        // fn = Min(fn-1,fn-2) + cost(n)
        if (cost.length <= 1) return 0;
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    public static void main(String[] args) {
        Lc746MinCostClimbingStairs2 lc = new Lc746MinCostClimbingStairs2();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(lc.minCostClimbingStairs(cost));
    }
}
