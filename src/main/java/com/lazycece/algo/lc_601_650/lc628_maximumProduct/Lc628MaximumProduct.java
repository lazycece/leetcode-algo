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

package com.lazycece.algo.lc_601_650.lc628_maximumProduct;

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/8/14
 */
public class Lc628MaximumProduct {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = nums[0] * nums[1];
        int r = nums[n - 1] * nums[n - 2];
        return Math.max(l * nums[n - 1], r * nums[n - 3]);
    }
}
