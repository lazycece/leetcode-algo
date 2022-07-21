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

package com.lazycece.algo.lc_201_250.lc220_containsNearbyAlmostDuplicate;

import java.util.TreeSet;

/**
 * 考虑int边界情况
 *
 * @author lazycece
 * @date 2022/7/19
 */
public class Lc220ContainsNearbyAlmostDuplicate2 {

    private TreeSet<Long> set = new TreeSet<>();

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if (n <= 1) return false;
        if (k == 0) return false;
        int l = 0;
        for (int i = 0; i < n; i++) {
            Long high = set.ceiling((long) nums[i] - (long) t);
            if (high != null && high <= nums[i] + t) {
                return true;
            }
            if (i - l == k) {
                // 控制窗口长度符合要求
                set.remove((long) nums[l]);
                l++;
            }
            set.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Lc220ContainsNearbyAlmostDuplicate2 lc = new Lc220ContainsNearbyAlmostDuplicate2();
        int[] nums = {1, 2, 2, 3, 4, 5};
        int k = 3;
        int t = 0;
        System.out.println(lc.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
