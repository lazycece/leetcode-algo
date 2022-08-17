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

package com.lazycece.algo.lc_551_600.lc581_findUnsortedSubarray;

import java.util.Stack;

/**
 * @author lazycece
 * @date 2022/8/18
 */
public class lc581FindUnsortedSubarray2 {
    public int findUnsortedSubarray(int[] nums) {

        int max = nums[0], min = nums[nums.length - 1];
        int l = -1, r = -1;
        for (int i = 0; i < nums.length; i++) {
            // 寻找右边界
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                r = i;
            }

            // 寻找左边界
            if (nums[nums.length - 1 - i] <= min) {
                min = nums[nums.length - 1 - i];
            } else {
                l = nums.length - i - 1;
            }
        }
        if (r == -1) return 0;
        return r - l + 1;

    }
}
