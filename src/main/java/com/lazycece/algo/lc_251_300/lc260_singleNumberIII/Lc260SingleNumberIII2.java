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

package com.lazycece.algo.lc_251_300.lc260_singleNumberIII;

/**
 * @author lazycece
 * @date 2022/8/29
 */
public class Lc260SingleNumberIII2 {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) sum ^= i;

        int flag = ((sum == Integer.MIN_VALUE) ? sum : (sum & -sum));
        int a = 0, b = 0;
        for (int i : nums) {
            if ((i & flag) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }
}
