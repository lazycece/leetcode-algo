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
public class Lc724PivotIndex2 {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) total += nums[i];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum * 2 + nums[i] == total) return i;
            sum += nums[i];
        }
        return -1;
    }
}
