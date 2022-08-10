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

package com.lazycece.algo.lc_601_650.lc636_findLongestChain;

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/8/10
 */
public class Lc646FindLongestChain {

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n <= 1) return n;
        Arrays.sort(pairs, (a, b) -> {
            int t = a[0] - b[0];
            return t == 0 ? a[1] - b[1] : t;
        });

        for (int[] a : pairs) {
            System.out.print(a[0] + "," + a[1] + "  ");
        }
        System.out.println();

        int res = 1, pre = pairs[0][1];
        for (int i = 1; i < n; i++) {
            System.out.print(pre + ",");
            if (pairs[i][0] > pre) {
                res++;
                pre = pairs[i][1];
            } else {
                pre = Math.min(pre, pairs[i][1]);
            }
        }
        return res;
    }
}
