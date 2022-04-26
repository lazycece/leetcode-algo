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

package com.lazycece.algo.lc_201_250.lc209_MinimumSizeSubarraySum;

/**
 * 暴力求解法，时间复杂度O(n^2)
 *
 * @author lazycece
 * @date 2022/4/26
 */
public class Lc209MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int n = 0;
            for (int j = i; j < nums.length; j++) {
                n += nums[j];
                if (n >= target) {
                    len = Math.min(len, j - i + 1);
                    break;
                }
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        Lc209MinimumSizeSubarraySum lc = new Lc209MinimumSizeSubarraySum();
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(lc.minSubArrayLen(7, nums));
        int[] nums1 = {1, 4, 4};
        System.out.println(lc.minSubArrayLen(4, nums1));
        int[] nums2 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(lc.minSubArrayLen(11, nums2));
    }

}
