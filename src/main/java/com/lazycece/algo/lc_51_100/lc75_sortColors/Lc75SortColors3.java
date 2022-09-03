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

package com.lazycece.algo.lc_51_100.lc75_sortColors;

/**
 * @author lazycece
 * @date 2022/9/3
 */
public class Lc75SortColors3 {
    public void sortColors(int[] nums) {
        // 空间复杂度要求O(1), 时间复杂度要求O(n)
        int l = 0, r = nums.length - 1;
        for (int i = 0; i <= r; i++) {
            while (i <= r && nums[r] == 2) r--;

            // 蓝色置换
            if (nums[i] == 2 && i < r) {
                nums[i--] = nums[r];
                nums[r] = 2;
                r--;
            } else if (nums[i] == 0 && i != l) {
                // 红色置换
                nums[i--] = nums[l];
                nums[l] = 0;
                l++;
            }
        }
    }
}
