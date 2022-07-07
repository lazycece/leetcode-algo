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

package com.lazycece.algo.lc_451_500.lc496_nextGreaterElement;

/**
 * @author lazycece
 * @date 2022/7/7
 */
public class Lc496NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            boolean r = false;
            for (; j < nums2.length; j++) {
                if (r && nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
                if (nums2[j] == nums1[i]) r = true;
            }
            if (j == nums2.length) res[i] = -1;
        }
        return res;
    }
}
