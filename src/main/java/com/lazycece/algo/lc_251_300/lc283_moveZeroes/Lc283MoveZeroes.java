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

package com.lazycece.algo.lc_251_300.lc283_moveZeroes;

/**
 * @author lazycece
 * @date 2022/8/3
 */
public class Lc283MoveZeroes {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        while (l <= r && r < n) {
            if (nums[l] != 0) {
                l++;
                r++;
                continue;
            }
            while (r < n && nums[r] == 0) r++;
            if (r >= n) break;
            nums[l] = nums[r];
            nums[r] = 0;
            l++;
            r++;
        }

    }
}
