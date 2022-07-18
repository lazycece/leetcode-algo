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

package com.lazycece.algo.lc_1_50.lc11_maxArea;

/***
 * 双指针，贪心思想，前提是定理证明
 *
 * @author lazycece
 * @date 2022/7/15
 */
public class Lc11MaxArea2 {

    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Lc11MaxArea2 lc = new Lc11MaxArea2();
//        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {1, 2, 1};
        int[] height = {2, 3, 10, 5, 7, 8, 9};
        System.out.println(lc.maxArea(height));
    }
}
