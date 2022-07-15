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

package com.lazycece.algo.lc_651_700.lc674_findLengthOfLCIS;

/**
 * 动态规划，空间优化
 *
 * @author lazycece
 * @date 2022/7/15
 */
public class Lc674FindLengthOfLCIS2 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int pre = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                pre = pre + 1;
            } else {
                pre = 1;
            }
            res = Math.max(res, pre);
        }
        return res;
    }
}
