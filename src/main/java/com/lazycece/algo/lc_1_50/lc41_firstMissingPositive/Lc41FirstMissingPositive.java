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

package com.lazycece.algo.lc_1_50.lc41_firstMissingPositive;

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/7/29
 */
public class Lc41FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) continue;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] == k) {
                k++;
                continue;
            }
            return k;
        }
        return k;
    }
}
