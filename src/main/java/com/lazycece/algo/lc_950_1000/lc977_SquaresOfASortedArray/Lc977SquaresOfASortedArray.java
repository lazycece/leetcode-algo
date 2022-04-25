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

package com.lazycece.algo.lc_950_1000.lc977_SquaresOfASortedArray;

import com.lazycece.utils.ArrayUtils;

/**
 * 双指针，时间复杂度O(n),空间复杂度O(n)
 * <p>
 * 平方后负数变正数，形成中心向两边增大的形式
 *
 * @author lazycece
 * @date 2022/4/25
 */
public class Lc977SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        int i = size - 1;
        int l = 0, r = size - 1;
        for (; l <= r; l++) {
            int l1 = nums[l] * nums[l];
            int r1 = nums[r] * nums[r];
            if (l1 >= r1) {
                result[i--] = l1;
            } else {
                result[i--] = r1;
                r--;
                // l 未更新时候需要--，因为for上会++
                l--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Lc977SquaresOfASortedArray lc = new Lc977SquaresOfASortedArray();
        int[] nums1 = {-4, -1, 0, 3, 10};
        ArrayUtils.print(lc.sortedSquares(nums1));
        int[] nums2 = {-7, -3, 2, 3, 11};
        ArrayUtils.print(lc.sortedSquares(nums2));
    }
}
