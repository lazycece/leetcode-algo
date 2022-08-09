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

package com.lazycece.algo.lc_151_200.lc198_rob;

/**
 * dp
 * f[i][2] = max(f[i][0],f[i][1]), f[i][0] 表示当前没有偷, f[i][1] 表示当前偷了
 * so
 * f[i][1] = f[i-1][0];
 * f[i][0] = max(f[i-1][0],f[i-1][1])
 *
 * @author lazycece
 * @date 2022/8/9
 */
public class Lc198Rob {

    public int rob(int[] nums) {
        int len = nums.length;
        int y = nums[0], n = 0;
        for (int i = 1; i < len; i++) {
            int t = y;
            y = n + nums[i];
            n = Math.max(t, n);
        }
        System.out.println(y + ", " + n);
        return Math.max(y, n);
    }
}
