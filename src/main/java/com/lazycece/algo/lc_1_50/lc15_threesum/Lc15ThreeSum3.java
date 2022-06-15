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

package com.lazycece.algo.lc_1_50.lc15_threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/6/15
 */
public class Lc15ThreeSum3 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            // 目标数去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int t = nums[l] + nums[r] + nums[i];
                if (t > 0) {
                    r--;
                } else if (t < 0) {
                    l++;
                } else {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 去重元素
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    // 指针移动位置
                    l++;
                    r--;
                }
            }
        }
        return list;
    }
}
