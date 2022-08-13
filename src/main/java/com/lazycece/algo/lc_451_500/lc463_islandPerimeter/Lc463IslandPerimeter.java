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

package com.lazycece.algo.lc_451_500.lc463_islandPerimeter;

/**
 * @author lazycece
 * @date 2022/8/13
 */
public class Lc463IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int per = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (j == 0 || grid[i][j - 1] == 0) per++;
                    if (i == 0 || grid[i - 1][j] == 0) per++;
                    if (i == m - 1 || grid[i + 1][j] == 0) per++;
                    if (j == n - 1 || grid[i][j + 1] == 0) per++;
                }
            }
        }
        return per;
    }
}
