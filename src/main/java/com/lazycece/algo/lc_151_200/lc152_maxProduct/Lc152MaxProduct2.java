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

package com.lazycece.algo.lc_151_200.lc152_maxProduct;

/**
 * dp
 * dp[j] 表示j到i的乘积值
 *
 * 空间复杂度On，实际复杂度On*n
 *
 * @author lazycece
 * @date 2022/8/14
 */
public class Lc152MaxProduct2 {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // dp[j] 表示j到i的乘积值
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < i; j++) {
                dp[j] = dp[j] * nums[i];
                res = Math.max(res, dp[j]);
            }
            dp[j] = nums[i];
            res = Math.max(res, dp[j]);
        }
        return res;
    }
}
