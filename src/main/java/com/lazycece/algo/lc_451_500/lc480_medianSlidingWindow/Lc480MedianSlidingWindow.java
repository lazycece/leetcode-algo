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

package com.lazycece.algo.lc_451_500.lc480_medianSlidingWindow;


import java.util.Arrays;

/**
 * 滑动窗口内部排序
 * 时间复杂度 O(n*logn)
 * 空间复杂度 O(n*n)
 *
 * @author lazycece
 * @date 2022/7/23
 */
public class Lc480MedianSlidingWindow {

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int len = n - k + 1;
        double[] res = new double[len];
        for (int i = 0; i < len; i++) {
            int[] temp = nums.clone();
            // [from,to),左闭右开区间
            Arrays.sort(temp, i, i + k);
            if (k % 2 == 0) {
                res[i] = ((double) temp[k / 2 + i] + (double) temp[k / 2 - 1 + i]) / 2;
            } else {
                res[i] = (double) temp[k / 2 + i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums = {1, 4, 2, 3};
        Lc480MedianSlidingWindow lc = new Lc480MedianSlidingWindow();
        double[] res = lc.medianSlidingWindow(nums, 4);
        System.out.println();
    }
}
