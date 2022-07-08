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

package com.lazycece.algo.lc_1_50.lc40_combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯,与39题的区别：源数组值会有重复,所以需要先对数组排序
 *
 * @author lazycece
 * @date 2022/7/9
 */
public class Lc40CombinationSum2 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return res;
    }

    private void helper(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) return;
        for (int i = index; i < candidates.length; i++) {
            // 去除重复
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
