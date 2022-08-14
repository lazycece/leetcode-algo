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

package com.lazycece.algo.lc_151_200.lc152_maxProduct;

/**
 * 空间复杂度O1，实际复杂度On
 *
 * @author lazycece
 * @date 2022/8/14
 */
public class Lc152MaxProduct3 {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int min = nums[0], max = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            int mn = min, mm = max;
            max = Math.max(nums[i], Math.max(mn * nums[i], mm * nums[i]));
            min = Math.min(nums[i], Math.min(mn * nums[i], mm * nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}
