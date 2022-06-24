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
 * 双指针，hash表去重
 *
 * @author lazycece
 * @date 2022/2/16
 */
public class Lc15ThreeSum4 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int t = nums[i] + nums[l] + nums[r];
                if (t > 0) {
                    r--;
                } else if (t < 0) {
                    l++;
                } else {
                    String str = String.format("%s_%s_%s", nums[i], nums[l], nums[r]);
                    if (!set.contains(str)) {
                        list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        set.add(str);
                    }
                    l++;
                    r--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = new Lc15ThreeSum4().threeSum(nums);
        System.out.println(result);
    }
}
