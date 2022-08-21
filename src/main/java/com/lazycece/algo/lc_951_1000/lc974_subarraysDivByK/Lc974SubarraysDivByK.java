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

package com.lazycece.algo.lc_951_1000.lc974_subarraysDivByK;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lazycece
 * @date 2022/8/21
 */
public class Lc974SubarraysDivByK {

    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int rem = (sum % k + k) % k;
            if (map.containsKey(rem)) {
                res += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return res;
    }
}
