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
 * @author lazycece
 * @date 2022/4/27
 */
public class Lc718MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {
        int len = 0;
        for (int i = 0; i < nums1.length; i++) {
            int t = i;
            for (int j = 0; j < nums2.length; j++) {
                if (i < nums1.length && nums1[i] == nums2[j]) {
                    i++;
                } else {
                    
                    break;
                }
            }
            len = Math.max(len, i - t);
            i = t;
        }
        return len;
    }

    public static void main(String[] args) {
        Lc718MaximumLengthOfRepeatedSubarray lc = new Lc718MaximumLengthOfRepeatedSubarray();
//        int[] nums1 = {1, 2, 3, 2, 1};
//        int[] nums2 = {3, 2, 1, 4, 7};
//        int[] nums1 = {0, 0, 0, 0, 0};
//        int[] nums2 = {0, 0, 0, 0, 0};
        int[] nums1 = {0, 0, 0, 0, 1};
        int[] nums2 = {1, 0, 0, 0, 0};
        System.out.println(lc.findLength(nums1, nums2));
    }
}
