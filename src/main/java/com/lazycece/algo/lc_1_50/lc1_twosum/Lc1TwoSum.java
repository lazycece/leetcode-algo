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

package com.lazycece.algo.lc_1_50.lc1_twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * <url>https://leetcode-cn.com/problems/two-sum/</url>
 *
 * @author lazycece
 * @date 2022/2/16
 */
public class Lc1TwoSum {

    /**
     * 时间复杂度O(n2)，空间复杂度O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            throw new IllegalArgumentException("parameter error");
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        throw new IllegalArgumentException("parameter error, there is no result");
    }

    /**
     * hash表法， 时间复杂度O(n)，空间复杂度O(n)
     */
    public int[] twoSumHash(int[] nums, int target) {
        if (nums.length < 2) {
            throw new IllegalArgumentException("parameter error");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{ map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("parameter error, there is no result");
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = new Lc1TwoSum().twoSum(nums, target);
        System.out.print(result[0] + "," + result[1]);
    }
}
