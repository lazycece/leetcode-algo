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

import java.util.HashMap;
import java.util.Map;

/**
 * @author lazycece
 * @date 2022/8/29
 */
public class Lc260SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        int[] res = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            if (en.getValue() == 1) {
                res[i++] = en.getKey();
                if (i == 2) break;
            }
        }
        return res;
    }
}
