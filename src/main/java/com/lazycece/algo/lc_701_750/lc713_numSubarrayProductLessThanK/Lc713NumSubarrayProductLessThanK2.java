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
 * 滑动窗口思路,
 * j到i 符合要求，则j++ 到i均符合要求，即存在 i-j+1 个结果
 *
 * @author lazycece
 * @date 2022/8/14
 */
public class Lc713NumSubarrayProductLessThanK2 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int m = 1;
        int j = 0;
        for (int i = 0; i < n; i++) {
            m = m * nums[i];
            while (j <= i && m >= k) {
                m = m / nums[j];
                j++;
            }
            if (m < k) res = res + i - j + 1;
        }
        return res;
    }
}
