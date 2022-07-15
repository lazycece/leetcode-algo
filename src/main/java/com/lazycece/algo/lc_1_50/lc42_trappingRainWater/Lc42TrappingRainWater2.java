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

package com.lazycece.algo.lc_1_50.lc42_trappingRainWater;

/**
 * 双指针，对dp的空间复杂度降维
 * f(i) = min(i_left_high,i_right_high)-hight[i]
 *
 * @author lazycece
 * @date 2022/7/7
 */
public class Lc42TrappingRainWater2 {

    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lMax = 0, rMax = 0;
        int sum = 0;
        while (l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if (lMax < rMax) {
                sum += lMax - height[l];
                l++;
            } else {
                sum += rMax - height[r];
                r--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Lc42TrappingRainWater2 lc = new Lc42TrappingRainWater2();
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(lc.trap(height));

    }
}
