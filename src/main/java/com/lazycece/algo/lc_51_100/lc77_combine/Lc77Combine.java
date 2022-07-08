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

package com.lazycece.algo.lc_51_100.lc77_combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/7/8
 */
public class Lc77Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, n, k, 1, new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, int n, int k, int i, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        while (i <= n) {
            list.add(i);
            helper(res, n, k, i + 1, list);
            list.remove(list.size() - 1);
            i++;
        }
    }

    public static void main(String[] args) {
        Lc77Combine lc = new Lc77Combine();
        System.out.println(lc.combine(4, 2));
    }
}
