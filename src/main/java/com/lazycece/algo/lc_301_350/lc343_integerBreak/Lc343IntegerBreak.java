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

package com.lazycece.algo.lc_301_350.lc343_integerBreak;

/**
 * @author lazycece
 * @date 2022/7/6
 */
public class Lc343IntegerBreak {

    public int integerBreak(int n) {
        // f(n)=max{ f(n-i)*f(i), i*(n-i)}
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max((i - j) * j, dp[j] * (i - j)));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Lc343IntegerBreak lc = new Lc343IntegerBreak();
        System.out.println(lc.integerBreak(10));
    }
}
