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

package com.lazycece.algo.lc_451_500.lc454_4sumii;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lazycece
 * @date 2022/6/15
 */
public class Lc454FourSumii {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        // 处理nums1和nums2两个数组的和情况
        for (int i : nums1) {
            for (int j : nums2) {
                int t = i + j;
                if (map.containsKey(t)) {
                    map.put(t, map.get(t) + 1);
                } else {
                    map.put(t, 1);
                }
            }
        }
        int cnt = 0;
        // 处理nums3和nums4两个数组的情况
        for (int i : nums3) {
            for (int j : nums4) {
                int t = -(i + j);
                if (map.containsKey(t)) {
                    cnt += map.get(t);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
