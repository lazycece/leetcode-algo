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

package com.lazycece.algo.lc_1_50.lc18_4sum;

import com.lazycece.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/6/15
 */
public class Lc18FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int temp = nums[i] + nums[j] + nums[l] + nums[r];
                    if (temp > target) {
                        r--;
                    } else if (temp < target) {
                        l++;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Lc18FourSum lc = new Lc18FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        ArrayUtils.print(lc.fourSum(nums, 0));
        int[] nums1 = {2, 2, 2, 2, 2};
        ArrayUtils.print(lc.fourSum(nums1, 8));
    }
}
