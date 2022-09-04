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

package com.lazycece.algo.lc_1551_1600.lc1582_numSpecial;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lazycece
 * @date 2022/9/4
 */
public class Lc1582NumSpecial {

    public int numSpecial(int[][] mat) {
        int res = 0;
        Set<Integer> sx = new HashSet<>();
        Set<Integer> sy = new HashSet<>();
        int x = mat.length, y = mat[0].length;
        int i = 0;
        while (i < x) {
            if (sx.contains(i)) continue;
            int j = 0;
            while (j < y) {
                if (sy.contains(j)) {
                    j++;
                    continue;
                }
                ;
                if (mat[i][j] == 1) {
                    int k = i + 1;
                    while (k < x && mat[k][j] == 0) k++;
                    if (k != x) {
                        sy.add(j);
                        j++;
                        continue;
                    }
                    k = i - 1;
                    while (k >= 0 && mat[k][j] == 0) k--;
                    if (k != -1) {
                        sy.add(j);
                        j++;
                        continue;
                    }
                    k = j + 1;
                    while (k < y && mat[i][k] == 0) k++;
                    if (k != y) {
                        sx.add(i);
                        break;
                    }
                    k = j - 1;
                    while (k >= 0 && mat[i][k] == 0) k--;
                    if (k != -1) {
                        sx.add(i);
                        break;
                    }
                    res++;
                    sx.add(i);
                    sy.add(j);
                }
                j++;
            }
            i++;
        }
        return res;

    }

    public static void main(String[] args) {
        Lc1582NumSpecial lc = new Lc1582NumSpecial();
        int[][] mat = {
                {1, 0, 0}
                , {0, 0, 1}
                , {1, 0, 0}
        };
        System.out.println(lc.numSpecial(mat));
    }
}
