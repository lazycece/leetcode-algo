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

package com.lazycece.algo.lc_301_350.lc349_IntersectionOfTwoArrays;

import com.lazycece.utils.ArrayUtils;

import java.util.*;

/**
 * @author lazycece
 * @date 2022/6/10
 */
public class Lc349IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i : set1) {
            if (set2.contains(i)) {
                list.add(i);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        Lc349IntersectionOfTwoArrays lc = new Lc349IntersectionOfTwoArrays();
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        ArrayUtils.print(lc.intersection(num1, num2));
        int[] num3 = {4, 9, 5};
        int[] num4 = {9, 4, 9, 8, 4};
        ArrayUtils.print(lc.intersection(num3, num4));
    }
}
