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

package com.lazycece.algo.lc_501_550.lc523_checkSubarraySum;

import java.util.HashMap;
import java.util.Map;

/**
 * //  同余定理 （a-b)/k=n => a%k==b%k
 *
 * @author lazycece
 * @date 2022/8/21
 */
public class Lc523CheckSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        // 空间初始化
        map.put(0, -1);
        int rem = 0;
        for (int i = 0; i < n; i++) {
            //  同余定理 （a-b)/k=n => a%k==b%k
            rem = (rem + nums[i]) % k;
            if (map.containsKey(rem)) {
                int l = map.get(rem);
                if (i - l >= 2) {
                    return true;
                }
                // 因为至少>=2，保留原来的index,不覆盖
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }
}
