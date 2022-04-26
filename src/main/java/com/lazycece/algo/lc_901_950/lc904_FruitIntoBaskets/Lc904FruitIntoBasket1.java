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

package com.lazycece.algo.lc_901_950.lc904_FruitIntoBaskets;

import java.util.*;

/**
 * 滑动窗口
 *
 * @author lazycece
 * @date 2022/4/27
 */
public class Lc904FruitIntoBasket1 {
    public int totalFruit(int[] fruits) {
        // 解决空间占用问题
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int len = Integer.MIN_VALUE;
        for (; r < fruits.length; r++) {
            map.putIfAbsent(fruits[r], 0);
            map.put(fruits[r], map.get(fruits[r]) + 1);
            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            len = Math.max(len, r - l + 1);
        }
        return len == Integer.MIN_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        Lc904FruitIntoBasket1 lc = new Lc904FruitIntoBasket1();
        int[] nums = {1, 2, 1};
        System.out.println(lc.totalFruit(nums));
        int[] nums1 = {0, 1, 2, 2};
        System.out.println(lc.totalFruit(nums1));
        int[] nums2 = {1, 2, 3, 2, 2};
        System.out.println(lc.totalFruit(nums2));
        int[] nums3 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(lc.totalFruit(nums3));

    }
}
