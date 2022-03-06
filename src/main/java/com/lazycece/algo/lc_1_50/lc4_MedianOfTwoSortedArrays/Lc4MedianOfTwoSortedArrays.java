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

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/2/21
 */
public class Lc4MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0;
        int[] num = new int[nums1.length + nums2.length];
        int i = 0;
        for (; i < nums1.length; i++) {
            num[i] = nums1[i];
        }
        for (int j = 0; j < nums2.length; j++) {
            num[i++] = nums2[j];
        }
        Arrays.sort(num);
        int k = num.length / 2;
        if (num.length % 2 == 0) {
            return (double) (num[k - 1] + num[k]) / 2;
        } else {
            return num[k];
        }

    }

    public static void main(String[] args) {
        Lc4MedianOfTwoSortedArrays lc4 = new Lc4MedianOfTwoSortedArrays();
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
