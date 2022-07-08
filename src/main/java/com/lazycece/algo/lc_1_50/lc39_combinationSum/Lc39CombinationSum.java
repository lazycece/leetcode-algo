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

package com.lazycece.algo.lc_1_50.lc39_combinationSum;

import java.util.*;

/**
 * @author lazycece
 * @date 2022/7/8
 */
public class Lc39CombinationSum {


    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private Set<String> set = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target == 0) {
            if (!helper()) {
                res.add(new ArrayList<>(list));
            }
            return res;
        }

        if (target < 0) return res;

        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSum(candidates, target - candidates[i]);
            list.remove(list.size() - 1);
        }
        return res;
    }

    private boolean helper() {
        List<Integer> t = new ArrayList<>(list);
        Collections.sort(t);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t.size(); i++) {
            if (i != 0) {
                sb.append("_");
            }
            sb.append(t.get(i));
        }
        String key = sb.toString();
        if (set.contains(key)) {
            return true;
        }
        set.add(key);
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {100, 200, 4, 2};
        int target = 400;
        Lc39CombinationSum lc = new Lc39CombinationSum();
        System.out.println(lc.combinationSum(arr, target));
    }
}
