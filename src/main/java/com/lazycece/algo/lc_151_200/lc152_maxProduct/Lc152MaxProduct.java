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
 * dp 超出内存限制
 * dp[i][j] = dp[i][j-1] * nums[i]
 * 实际中二维dp数组只使用到了左下半部分，且是自上而下复用dp
 * 可考虑空间降维
 *
 * @author lazycece
 * @date 2022/8/14
 */
public class Lc152MaxProduct {

    public int maxProduct(int[] nums) {
        // -2,-2,-2,-2,-1,-1
        //-2,4,4,16,8,16
        int n = nums.length;
        int[][] dp = new int[n][n];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < i; j++) {
                dp[j][i] = dp[j][i - 1] * nums[i];
                res = Math.max(res, dp[j][i]);
            }
            dp[j][i] = nums[i];
            res = Math.max(res, dp[j][i]);
        }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(dp[j][i]+",");
        //     }
        //         System.out.println();
        // }
        return res;
    }
}
