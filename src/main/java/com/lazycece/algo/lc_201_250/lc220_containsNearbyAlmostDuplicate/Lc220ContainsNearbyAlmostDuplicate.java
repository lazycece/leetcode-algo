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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/7/19
 */
public class Lc220ContainsNearbyAlmostDuplicate {

    private List<Long> list = new ArrayList<>();

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if (n <= 1) return false;
        if (k == 0) return false;
        int l = 0;
        for (int i = 0; i < n; i++) {
            if (!list.isEmpty() && match(nums[i], t)) {
                return true;
            }
            if (i - l == k) {
                // 控制窗口长度符合要求
                list.remove((long) nums[l]);
                l++;
            }
            list.add((long) nums[i]);
        }
        return false;
    }

    private boolean match(int num, int t) {
        Collections.sort(list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (num == list.get(l)) return true;
            if (num == list.get(r)) return true;
            int mid = (l + r) / 2;
            if (list.get(mid) == null) return true;
            else if (num < list.get(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (Math.abs(num - list.get(l)) <= t) return true;
        if (l + 1 < list.size() && Math.abs(num - list.get(l + 1)) <= t) return true;
        if (l - 1 >= 0 && Math.abs(num - list.get(l - 1)) <= t) return true;
        return false;
    }

    public static void main(String[] args) {
        Lc220ContainsNearbyAlmostDuplicate lc = new Lc220ContainsNearbyAlmostDuplicate();
        int[] nums = {4, 1, 6, 3};
        int k = 100;
        int t = 1;
        System.out.println(lc.containsNearbyAlmostDuplicate(nums, k, t));
    }
}