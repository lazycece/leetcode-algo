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

package com.lazycece.algo.lc_251_300.lc287_findDuplicate;


/**
 * 二分查找特性
 *
 * @author lazycece
 * @date 2022/8/22
 */
public class Lc287FindDuplicate2 {

    public int findDuplicate(int[] nums) {
        // 二分法，利用题意特性，1到n的数字
        int n = nums.length;
        int l = 1, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            // 寻找比中位数小or等于的数
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) cnt++;
            }

            if (cnt <= mid) {
                // mid 是符合数据要求区间的，故l=mid+1;
                l = mid + 1;
            } else {
                // cnt >mid,
                r = mid;
            }
        }
        return l;
    }
}
