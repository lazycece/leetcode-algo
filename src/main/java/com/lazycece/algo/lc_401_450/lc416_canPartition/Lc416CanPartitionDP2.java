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

package com.lazycece.algo.lc_401_450.lc416_canPartition;

/**
 * 0/1 背包问题, dp矩阵
 *
 * @author lazycece
 * @date 2022/7/13
 */
public class Lc416CanPartitionDP2 {

    public boolean canPartition(int[] nums) {
        // 数量小于2，无法拆分2个子集
        if (nums.length < 2) return false;
        int sum = 0;
        int maxN = 0;
        for (int i : nums) {
            sum += i;
            maxN = Math.max(maxN, i);
        }
        // 奇数无法拆分两个和
        if (sum % 2 != 0) return false;
        int subNum = sum / 2;

        // 如果最大的数大于一半，那不可能做出拆分
        if (maxN > subNum) return false;
        // 如果最大的数等于一半，可以明确能拆分
        if (maxN == subNum) return true;

        boolean[][] dp = new boolean[nums.length][subNum + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= subNum; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length - 1][subNum];
    }

    public static void main(String[] args) {
        Lc416CanPartitionDP2 lc = new Lc416CanPartitionDP2();
        int[] nums = {1, 5, 11, 5};
        System.out.println(lc.canPartition(nums));
    }
}
