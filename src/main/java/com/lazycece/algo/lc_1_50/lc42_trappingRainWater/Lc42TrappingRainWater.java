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
 * 动态规划
 * f(i) = min(i_left_high,i_right_high)-hight[i]
 *
 * @author lazycece
 * @date 2022/7/7
 */
public class Lc42TrappingRainWater {

    public int trap(int[] height) {
        int[] lMaxH = new int[height.length];
        lMaxH[0] = 0;
        int[] rMaxH = new int[height.length];
        rMaxH[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rMaxH[i] = Math.max(rMaxH[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            lMaxH[i] = Math.max(height[i - 1], lMaxH[i - 1]);
            int tmp = Math.min(lMaxH[i], rMaxH[i]) - height[i];
            if (tmp > 0) {
                sum += tmp;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Lc42TrappingRainWater lc = new Lc42TrappingRainWater();
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(lc.trap(height));

    }
}
