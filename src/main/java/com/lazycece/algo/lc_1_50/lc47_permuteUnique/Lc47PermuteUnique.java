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

package com.lazycece.algo.lc_1_50.lc47_permuteUnique;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lazycece
 * @date 2022/7/11
 */
public class Lc47PermuteUnique {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private boolean[] flag;
    private Set<String> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        flag = new boolean[nums.length];
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        if (list.size() == nums.length) {
            String key = "";
            for (Integer in : list) {
                key += in;
            }
            if (!set.contains(key)) {
                res.add(new ArrayList<>(list));
                set.add(key);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 因为存在重复数，所以只能进行下标打标识
            if (flag[i]) continue;
            list.add(nums[i]);
            flag[i] = true;
            dfs(nums);
            list.remove(list.size() - 1);
            flag[i] = false;
        }
    }
}
