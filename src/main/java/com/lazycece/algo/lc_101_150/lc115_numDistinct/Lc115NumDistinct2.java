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

package com.lazycece.algo.lc_101_150.lc115_numDistinct;

/**
 * dp[i][j]: 以i为结尾的字符串中，j所属字符串的个数
 * = dp[i-1][j-1] + dp[i-1][j], if a[i]==b[j],当相等时,存在两种case: 匹配j, 删除j不进行匹配
 * = dp[i-1][j], if a[i]!=b[j],当不等时,一定是删除不匹配
 *
 * @author lazycece
 * @date 2022/7/16
 */
public class Lc115NumDistinct2 {

    public int numDistinct(String s, String t) {
        int ns = s.length(), nt = t.length();
        int[] dp = new int[nt + 1];
        dp[0] = 1;
        for (int i = 1; i <= ns; i++) {
            for (int j = nt; j > 0; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 倒叙处理，dp[j-1] 相当于i-1下的dp[j-1]
                    // dp[j] 相当于i-1下的dp[j]
                    dp[j] = dp[j - 1] + dp[j];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[nt];
    }

    public static void main(String[] args) {
        Lc115NumDistinct2 lc = new Lc115NumDistinct2();
        System.out.println(lc.numDistinct("rabbbit", "rabit"));
    }
}
