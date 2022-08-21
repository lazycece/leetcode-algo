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

package com.lazycece.algo.lc_701_750.lc724_pivotIndex;

/**
 * @author lazycece
 * @date 2022/8/21
 */
public class Lc724PivotIndex {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        // 前后缀计算
        int[] lp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            lp[i] = lp[i - 1] + nums[i - 1];
        }
        int sum = 0;
        int res = -1;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum == lp[i + 1]) {
                res = i;
            }
        }
        return res;
    }
}
