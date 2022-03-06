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

import java.util.*;

/**
 * 借用2sum思想，空间换时间
 *
 * @author lazycece
 * @date 2022/2/16
 */
public class Lc15ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            Set<Integer> set2 = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int temp = target - nums[j];
                String str = nums[i] + "_" + temp + "_" + nums[j];
                if (set2.contains(temp) && !set.contains(str)) {
                    result.add(Arrays.asList(nums[i], temp, nums[j]));
                    set.add(str);
                }
                set2.add(nums[j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = new Lc15ThreeSum().threeSum(nums);
        System.out.println(result);
    }
}
