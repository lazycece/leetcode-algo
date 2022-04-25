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

package com.lazycece.algo.lc_1_50.lc27_RemoveElement;

/**
 * 暴力法：时间复杂度O(n^2)
 *
 * @author lazycece
 * @date 2022/4/25
 */
public class Lc27RemoveElement {

    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] != val) {
                continue;
            }
            for (int j = i + 1; j < size; j++) {
                nums[j - 1] = nums[j];
            }
            size--;
            i--;
        }
        return size;
    }

    public static void main(String[] args) {
        Lc27RemoveElement lc = new Lc27RemoveElement();
        int[] nums = {3, 2, 2, 3};
        System.out.println(lc.removeElement(nums, 3));

        int[] nums1 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(lc.removeElement(nums1, 2));

    }
}
