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
 * 乘积注意整型边界问题
 * On*n 超出时间限制
 *
 * @author lazycece
 * @date 2022/8/14
 */
public class Lc713NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < i; j++) {
                // 处理边界情况
                dp[j] = Math.min(dp[j] * nums[i], 1000000);
                if (dp[j] < k) {
                    res++;
                }
            }
            dp[j] = nums[i];

            if (dp[j] < k) {
                res++;
            }
        }
        return res;
    }
}
