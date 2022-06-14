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

package com.lazycece.algo.lc_301_350.lc350_IntersectionOfTwoArraysii;

import com.lazycece.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/6/10
 */
public class Lc350IntersectionOfTwoArraysii {

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] n = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            n[nums1[i]]++;
        }
        int[] t = new int[1001];
        for (int i = 0; i < nums2.length; i++) {
            t[nums2[i]]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            int x = Math.min(n[i], t[i]);
            while (x-- > 0) {
                list.add(i);
            }
        }
        int[] r = new int[list.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = list.get(i);
        }
        return r;
    }

    public static void main(String[] args) {
        Lc350IntersectionOfTwoArraysii lc = new Lc350IntersectionOfTwoArraysii();
//        int[] num1 = {1, 2, 2, 1};
//        int[] num2 = {2, 2};
//        ArrayUtils.print(lc.intersect(num1, num2));
//        int[] num3 = {4, 9, 5};
//        int[] num4 = {9, 4, 9, 8, 4};
//        ArrayUtils.print(lc.intersect(num3, num4));

        int[] num5 = {8, 0, 3};
        int[] num6 = {0, 0};
        ArrayUtils.print(lc.intersect(num5, num6));
    }
}
