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

package com.lazycece.algo.lc_51_100.lc73_setZeroes;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/9/8
 */
public class Lc73SetZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) list.add(new Pair<>(i, j));
            }
        }

        for (Pair<Integer, Integer> p : list) {
            int x = p.getKey(), y = p.getValue();
            int i = x;
            while (i-- > 0) matrix[i][y] = 0;
            i = x;
            while (i++ < m - 1) matrix[i][y] = 0;
            i = y;
            while (i-- > 0) matrix[x][i] = 0;
            i = y;
            while (i++ < n - 1) matrix[x][i] = 0;
        }
    }
}
