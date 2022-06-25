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

/**
 * @author lazycece
 * @date 2022/6/25
 */
public class Lc239MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (k > len) {
            throw new RuntimeException("param error");
        }
        int[] result = new int[len - k + 1];
        for (int l = 0, r = 0; r < len; r++) {
            if (r - l + 1 < k) {
                continue;
            }
            int max = Integer.MIN_VALUE;
            for (int i = l; i <= r; i++) {
                max = Math.max(max, nums[i]);
            }
            result[l] = max;
            l++;
        }
        return result;
    }

    public static void main(String[] args) {
        Lc239MaxSlidingWindow lc = new Lc239MaxSlidingWindow();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        ArrayUtils.print(lc.maxSlidingWindow(nums, 3));
    }
}
