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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 滑动窗口
 *
 * @author lazycece
 * @date 2022/4/27
 */
public class Lc904FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        List<Integer> list = new ArrayList<>();
        int l = 0, r = 0;
        int len = Integer.MIN_VALUE;
        for (; r < fruits.length; r++) {
            list.add(fruits[r]);
            Set<Integer> set = new HashSet<>(list);
            while (set.size() > 2) {
                list.remove(0);
                l++;
                set = new HashSet<>(list);
            }
            len = Math.max(len, r - l + 1);
        }
        return len == Integer.MIN_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        Lc904FruitIntoBaskets lc = new Lc904FruitIntoBaskets();
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
