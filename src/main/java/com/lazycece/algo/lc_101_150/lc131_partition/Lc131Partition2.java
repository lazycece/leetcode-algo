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
import java.util.List;

/**
 * 回溯，判断回文的时候进行记忆，用空间换取；
 *
 * @author lazycece
 * @date 2022/7/9
 */
public class Lc131Partition2 {

    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    int[][] flag;

    public List<List<String>> partition(String s) {
        if (s.length() == 0) return res;
        flag = new int[s.length()][s.length()];
        partition(s, 0);
        return res;
    }

    private void partition(String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (!helper(s, index, i)) continue;
            list.add(s.substring(index, i + 1));
            partition(s, i + 1);
            list.remove(list.size() - 1);
        }
    }

    private boolean helper(String s, int l, int r) {
        if (l >= r) return true;
        if (flag[l][r] == 1) {
            return true;
        }
        if (flag[l][r] == -1) {
            return false;
        }
        if (s.charAt(l) != s.charAt(r)) {
            flag[l][r] = -1;
            return false;
        }
        return helper(s, ++l, --r);
    }

    public static void main(String[] args) {
        Lc131Partition2 lc = new Lc131Partition2();
        System.out.println(lc.partition("aab"));
    }

}
