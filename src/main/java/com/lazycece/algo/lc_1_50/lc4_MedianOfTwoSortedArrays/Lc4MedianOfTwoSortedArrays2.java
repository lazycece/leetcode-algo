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

package com.lazycece.algo.lc_1_50.lc4_MedianOfTwoSortedArrays;


/**
 * @author lazycece
 * @date 2022/2/21
 */
public class Lc4MedianOfTwoSortedArrays2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] mg = new int[m + n];
        if (m + n == 0) return 0;
        int l = 0, r = 0, i = 0;
        while (l < m && r < n) {
            if (nums1[l] < nums2[r]) {
                mg[i++] = nums1[l++];
            } else if (nums2[r] < nums1[l]) {
                mg[i++] = nums2[r++];
            } else {
                mg[i++] = nums1[l++];
                mg[i++] = nums2[r++];
            }
        }
        while (l < m) {
            mg[i++] = nums1[l++];
        }
        while (r < n) {
            mg[i++] = nums2[r++];
        }

        int k = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            return (double) (mg[k - 1] + mg[k]) / 2;
        } else {
            return (double) mg[k];
        }
    }

    public static void main(String[] args) {
        Lc4MedianOfTwoSortedArrays2 lc4 = new Lc4MedianOfTwoSortedArrays2();
//        System.out.println(lc4.findMedianSortedArrays(
//                new int[]{1, 2},
//                new int[]{3, 4}));
//        System.out.println(lc4.findMedianSortedArrays(
//                new int[]{1, 3},
//                new int[]{2}));
        System.out.println(lc4.findMedianSortedArrays(
                new int[]{1},
                new int[]{}));
    }
}
