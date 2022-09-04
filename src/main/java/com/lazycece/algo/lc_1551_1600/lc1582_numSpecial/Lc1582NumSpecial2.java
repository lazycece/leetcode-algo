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

/**
 * @author lazycece
 * @date 2022/9/4
 */
public class Lc1582NumSpecial2 {

    public int numSpecial(int[][] mat) {
        int res = 0;
        int x = mat.length, y = mat[0].length;
        int[] lx = new int[x];
        int[] ly = new int[y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (mat[i][j] == 1) {
                    lx[i]++;
                    ly[j]++;
                }
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (mat[i][j] == 1 && lx[i] == 1 && ly[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
