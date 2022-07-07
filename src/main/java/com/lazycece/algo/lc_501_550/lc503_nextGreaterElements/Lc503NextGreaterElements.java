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

package com.lazycece.algo.lc_501_550.lc503_nextGreaterElements;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author lazycece
 * @date 2022/7/7
 */
public class Lc503NextGreaterElements {

    public int[] nextGreaterElements(int[] nums) {

        // 数组扩容遍历
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        boolean l = false;
        for (int i = 0; i < 2 * len - 1; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek() % len]) {
                res[stack.pop() % len] = nums[i % len];
            }
            stack.add(i);
        }
        return res;
    }
}
