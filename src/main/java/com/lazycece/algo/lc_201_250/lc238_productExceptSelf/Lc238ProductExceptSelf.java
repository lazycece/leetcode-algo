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

package com.lazycece.algo.lc_201_250.lc238_productExceptSelf;

/**
 * 时间复杂度On, 空间复杂度On
 * 前后缀思想
 *
 * @author lazycece
 * @date 2022/8/14
 */
public class Lc238ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rp = new int[n];
        rp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rp[i] = rp[i + 1] * nums[i + 1];
        }
        int lp = 1;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = lp * rp[i];
            lp = lp * nums[i];
        }
        return answer;
    }
}
