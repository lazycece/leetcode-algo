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
public class Lc75SortColors2 {

    public void sortColors(int[] nums) {
        // 空间复杂度要求O(1), 时间复杂度要求O(n)
        int r = 0, w = 0, b = 0;
        for (int i : nums) {
            if (i == 0) r++;
            else if (i == 1) w++;
            else b++;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (b-- > 0) {
                nums[i] = 2;
            } else if (w-- > 0) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }
    }
}
