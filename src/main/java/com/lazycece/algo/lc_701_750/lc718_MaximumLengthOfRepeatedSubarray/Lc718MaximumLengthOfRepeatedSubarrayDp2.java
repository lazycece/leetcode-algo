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

package com.lazycece.algo.lc_701_750.lc718_MaximumLengthOfRepeatedSubarray;

/**
 * 动态规划
 * dp[j]: 子数组中结尾为i元素与j元素的的情况，
 * = dp[j-1]+1, if a[i-1]==b[j-1]
 * = 1, if a[i-1]==b[j-1]&&(j==0)
 * = 0, if a[i-1]!=b[j-1]
 *
 * @author lazycece
 * @date 2022/4/27
 */
public class Lc718MaximumLengthOfRepeatedSubarrayDp2 {

    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        int[] dp = new int[nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    if (j == 0) dp[j] = 1;
                    else dp[j] = dp[j - 1] + 1;
                    res = Math.max(res, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc718MaximumLengthOfRepeatedSubarrayDp2 lc = new Lc718MaximumLengthOfRepeatedSubarrayDp2();
//        int[] nums1 = {1, 2, 3, 2, 1};
//        int[] nums2 = {3, 2, 1, 4, 7};
//        int[] nums1 = {0, 0, 0, 0, 0};
//        int[] nums2 = {0, 0, 0, 0, 0};
//        int[] nums1 = {0, 1, 1, 1, 1};
//        int[] nums2 = {1, 0, 1, 0, 1};
        int[] nums1 = {1, 0, 0, 0, 1};
        int[] nums2 = {1, 0, 0, 1, 1};
        System.out.println(lc.findLength(nums1, nums2));
        int[] a = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int[] b = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(lc.findLength(a, b));
    }
}
