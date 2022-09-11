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

package com.lazycece.algo.lc_701_750.lc713_numSubarrayProductLessThanK;

/**
 * @author lazycece
 * @date 2022/9/11
 */
public class Lc713NumSubarrayProductLessThanK3 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int pro = 1;
        int res = 0;
        for (int r = 0; r < n; r++) {
            pro *= nums[r];
            while (pro >= k && l <= r) {
                pro /= nums[l++];
            }
            if (pro < k) {
                res += r - l + 1;
            }
        }
        return res;
    }
}
