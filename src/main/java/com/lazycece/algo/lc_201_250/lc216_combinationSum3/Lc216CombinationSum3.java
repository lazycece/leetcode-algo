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

package com.lazycece.algo.lc_201_250.lc216_combinationSum3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/7/9
 */
public class Lc216CombinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) arr[i] = i + 1;
        helper(arr, n, k, 0);
        return res;
    }

    private void helper(int[] arr, int target, int k, int index) {
        if (target == 0 && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) return;
        if (list.size() >= k) return;
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            helper(arr, target - arr[i], k, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lc216CombinationSum3 lc = new Lc216CombinationSum3();
        System.out.println(lc.combinationSum3(3, 7));
    }
}
