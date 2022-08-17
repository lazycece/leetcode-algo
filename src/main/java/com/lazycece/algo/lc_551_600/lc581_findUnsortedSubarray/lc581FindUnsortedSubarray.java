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

package com.lazycece.algo.lc_551_600.lc581_findUnsortedSubarray;

import java.util.Stack;

/**
 * @author lazycece
 * @date 2022/8/18
 */
public class lc581FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int l = nums.length, r = -1, lm = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                int index = st.pop();
                l = Math.min(l, index);
                lm = Math.max(lm, nums[index]);
            }
            if (lm > nums[i]) r = i;
            st.add(i);
        }
        if (r == -1) return 0;
        return r - l + 1;
    }
}
