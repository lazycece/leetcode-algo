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

package com.lazycece.algo.lc_601_650.lc628_maximumProduct;

/**
 * @author lazycece
 * @date 2022/8/14
 */
public class Lc628MaximumProduct2 {

    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = min1;
        int mx1 = Integer.MIN_VALUE, mx2 = mx1, mx3 = mx1;
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (t < min1) {
                min2 = min1;
                min1 = t;
            } else if (t < min2) {
                min2 = t;
            }

            if (t > mx1) {
                mx3 = mx2;
                mx2 = mx1;
                mx1 = t;
            } else if (t > mx2) {
                mx3 = mx2;
                mx2 = t;
            } else if (t > mx3) {
                mx3 = t;
            }
        }

        return Math.max(min1 * min2 * mx1, mx1 * mx2 * mx3);

    }
}
