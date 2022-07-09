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
 * @author lazycece
 * @date 2022/7/9
 */
public class Lc131Partition {

    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s.length() == 0) return res;
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
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Lc131Partition lc = new Lc131Partition();
        System.out.println(lc.partition("aab"));
    }

}
