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

package com.lazycece.algo.lc_251_300.lc300_lengthOfLIS;

import com.lazycece.utils.ArrayUtils;

import java.util.Arrays;

/**
 * 动态规划： dp[i] = max(dp[i], dp[j] + 1) ，0=<j<i
 *
 * @author lazycece
 * @date 2022/7/15
 */
public class Lc300LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        ArrayUtils.print(dp);

        return res;
    }

    public static void main(String[] args) {
        Lc300LengthOfLIS lc = new Lc300LengthOfLIS();
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lc.lengthOfLIS(nums));
    }
}
