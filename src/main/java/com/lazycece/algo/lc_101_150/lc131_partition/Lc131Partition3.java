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

package com.lazycece.algo.lc_101_150.lc131_partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯+ 动态规划
 *
 * @author lazycece
 * @date 2022/7/9
 */
public class Lc131Partition3 {

    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        if (s.length() == 0) return res;
        dpHelper(s);
        partition(s, 0);
        return res;
    }

    private void dpHelper(String s) {
        dp = new boolean[s.length()][s.length()];
        // init
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], true);
        }
        // construct dp space
        for (int i = 0; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = dp[j + 1][i - 1] && s.charAt(i) == s.charAt(j);
            }
        }
    }

    private void partition(String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (!dp[index][i]) continue;
            list.add(s.substring(index, i + 1));
            partition(s, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lc131Partition3 lc = new Lc131Partition3();
        System.out.println(lc.partition("aab"));
    }

}
