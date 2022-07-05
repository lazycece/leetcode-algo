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

package com.lazycece.algo.lc_301_350.lc347_TopKFrequent;

import com.lazycece.utils.ArrayUtils;

import java.util.*;

/**
 * @author lazycece
 * @date 2022/6/25
 */
public class Lc347TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        if (k == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        int len = Math.min(k, map.size());
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int cnt = values.get(values.size() - i - 1);
            int key = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == cnt) {
                    res[i] = entry.getKey();
                    key = entry.getKey();
                }
            }
            map.remove(key);
        }
        return res;
    }

    public static void main(String[] args) {
        Lc347TopKFrequent lc = new Lc347TopKFrequent();
        int[] nums = {1, 1, 1, 2, 2,2, 3};
        int k = 2;
        ArrayUtils.print(lc.topKFrequent(nums, k));
    }
}
