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

package com.lazycece.algo.lc_1_50.lc46_permute;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/7/11
 */
public class Lc46Permute {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums);
            list.remove(list.size() - 1);
        }
    }
}
