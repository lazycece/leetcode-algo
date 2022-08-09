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

package com.lazycece.algo.lc_301_350.lc324_wiggleSort;

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/8/9
 */
public class Lc324WiggleSort {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) return;
        int[] a = nums.clone();
        Arrays.sort(a);
        int l = (n + 1) / 2 - 1, r = n - 1;
        for (int i = 0; i < n; ) {
            nums[i++] = a[l--];
            if (i < n) {
                nums[i++] = a[r--];
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2, 2, 3, 3};

        int[] nums = {4, 5, 5, 6};
        Lc324WiggleSort lc = new Lc324WiggleSort();
        lc.wiggleSort(nums);
        System.out.println();
    }
}
