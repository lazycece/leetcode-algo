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

import java.util.Stack;

/**
 * 单调栈
 *
 * @author lazycece
 * @date 2022/7/7
 */
public class Lc42TrappingRainWater3 {

    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            // 保持stack中的元素单调递减,遇到增的元素停止并计算
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int index = stack.pop();
                if (stack.isEmpty()) break;
                int l = stack.peek();
                sum += (Math.min(height[l], height[i]) - height[index]) * (i - l - 1);
            }
            stack.add(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Lc42TrappingRainWater3 lc = new Lc42TrappingRainWater3();
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(lc.trap(height));

    }
}
