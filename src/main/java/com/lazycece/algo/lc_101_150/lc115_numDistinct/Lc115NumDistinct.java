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
public class Lc115NumDistinct {

    public int numDistinct(String s, String t) {
        int ns = s.length(), nt = t.length();
        int[][] dp = new int[ns + 1][nt + 1];
        for (int i = 0; i < ns; i++) {
            // 以s[i-1]为结尾的字符串中，空串的个数
            dp[i][0] = 1;
        }
        for (int i = 1; i <= ns; i++) {
            for (int j = 1; j <= nt; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[ns][nt];
    }

    public static void main(String[] args) {
        Lc115NumDistinct lc = new Lc115NumDistinct();
        System.out.println(lc.numDistinct("rabbbit", "rabit"));
    }
}
