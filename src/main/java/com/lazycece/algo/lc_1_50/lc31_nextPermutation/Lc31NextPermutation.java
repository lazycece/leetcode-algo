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

package com.lazycece.algo.lc_1_50.lc31_nextPermutation;

/**
 * @author lazycece
 * @date 2022/8/15
 */
public class Lc31NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            // 反转字符串
            reverse(nums, 0, n - 1);
        } else {
            // 内部处理
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
            reverse(nums, i + 1, n - 1);
        }
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[r];
            nums[r] = nums[l];
            nums[l] = t;
            l++;
            r--;
        }
    }

}
