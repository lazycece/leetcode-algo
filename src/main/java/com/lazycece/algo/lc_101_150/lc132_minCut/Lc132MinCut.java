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

package com.lazycece.algo.lc_101_150.lc132_minCut;

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/7/9
 */
public class Lc132MinCut {

    private boolean[][] dp;

    public int minCut(String s) {
        if (s.length() == 0) return 0;
        dpHelper(s);
        int[] f = new int[s.length()];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                for (int k = 0; k < i; k++) {
                    if (dp[k + 1][i]) {
                        f[i] = Math.min(f[k] + 1, f[i]);
                    }
                }
            }
        }

        return f[s.length() - 1];
    }

    private void dpHelper(String s) {
        dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = dp[j + 1][i - 1] && s.charAt(j) == s.charAt(i);
            }
        }
    }


    public static void main(String[] args) {
        Lc132MinCut lc = new Lc132MinCut();
        System.out.println(lc.minCut("aab"));
        System.out.println(lc.minCut("a"));
        System.out.println(lc.minCut("ab"));
        System.out.println(lc.minCut("ababababababababababababcbabababababababababababa"));

    }
}
