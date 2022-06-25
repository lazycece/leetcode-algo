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

package com.lazycece.algo.lc_201_250.lc239_MaxSlidingWindow;

import com.lazycece.utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 着重考察寻找最大值的时间复杂度
 * --题目提示部分无效--
 *
 * @author lazycece
 * @date 2022/6/25
 */
public class Lc239MaxSlidingWindow2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (k > len) {
            throw new RuntimeException("param error");
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[len - k + 1];
        int index = 0;
        for (int i = 0; i < len; i++) {
            //计算符合要求的区间 r-l+1<=k
            while (!deque.isEmpty() && deque.peek() < (i - k + 1)) {
                deque.pop();
            }
            // 处理当前值与单调值的问题
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.add(i);
            if (i + 1 >= k) {
                result[index++] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Lc239MaxSlidingWindow2 lc = new Lc239MaxSlidingWindow2();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        ArrayUtils.print(lc.maxSlidingWindow(nums, 3));

        int[] num2 = {7, 2, 4};
        ArrayUtils.print(lc.maxSlidingWindow(num2, 2));
    }
}
