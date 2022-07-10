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

package com.lazycece.algo.lc_51_100.lc78_subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/7/10
 */
public class Lc78Subsets {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // []空数组可以当i=0的时候完成设置
        for (int i = 0; i <= nums.length; i++) {
            helper(nums, 0, i);
        }
        return res;
    }

    private void helper(int[] nums, int index, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        // i的遍历范围，即剪枝问题 i < nums.length - k + 1
        // if nums.length=3;
        // k=1,i<3-1+1=3,i最多取值下标2
        // k=2,i<3-2+1=2,i最多取值下标1
        // k=3,i<3-3+1=1,i最多取值下标0
        for (int i = index; i < nums.length - k + 1; i++) {
            list.add(nums[i]);
            helper(nums, i + 1, k - 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lc78Subsets lc = new Lc78Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(lc.subsets(nums));
    }
}
