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

package com.lazycece.sort;

import com.lazycece.utils.ArrayUtils;

/**
 * @author lazycece
 * @date 2022/7/5
 */
public class QuickSort {

    public void quickSort(int[] nums, int low, int high) {

        int l = low, r = high;
        int temp = nums[low];

        while (l < r) {
            while (l < r && nums[r] >= temp) {
                r--;
            }
            if (l < r) {
                nums[l] = nums[r];
                nums[r] = temp;
            }
            while (l < r && nums[l] <= temp) {
                l++;
            }
            if (l < r) {
                nums[r] = nums[l];
                nums[l] = temp;
            }
        }
        if (l > low) {
            quickSort(nums, low, l - 1);
        }
        if (r < high) {
            quickSort(nums, r + 1, high);
        }

    }

    public static void main(String[] args) {
        int[] nums = {12, 20, 5, 16, 15, 1, 30, 45};
        QuickSort sort = new QuickSort();
        sort.quickSort(nums, 0, nums.length - 1);
        ArrayUtils.print(nums);
    }
}
