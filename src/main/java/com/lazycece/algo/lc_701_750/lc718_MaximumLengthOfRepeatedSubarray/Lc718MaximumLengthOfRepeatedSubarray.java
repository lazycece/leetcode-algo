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
 * 暴力法求解
 *
 * @author lazycece
 * @date 2022/4/27
 */
public class Lc718MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {
        int len = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                {
                    int k = 0;
                    while (i + k < nums1.length && j + k < nums2.length && nums1[i + k] == nums2[j + k]) {
                        k++;
                    }
                    len = Math.max(len, k);
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Lc718MaximumLengthOfRepeatedSubarray lc = new Lc718MaximumLengthOfRepeatedSubarray();
//        int[] nums1 = {1, 2, 3, 2, 1};
//        int[] nums2 = {3, 2, 1, 4, 7};
//        int[] nums1 = {0, 0, 0, 0, 0};
//        int[] nums2 = {0, 0, 0, 0, 0};
//        int[] nums1 = {0, 1, 1, 1, 1};
//        int[] nums2 = {1, 0, 1, 0, 1};
//        System.out.println(lc.findLength(nums1, nums2));
        int[] a = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int[] b = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(lc.findLength(a, b));
    }
}
