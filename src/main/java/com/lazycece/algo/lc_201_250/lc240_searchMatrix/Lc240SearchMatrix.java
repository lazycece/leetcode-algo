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

package com.lazycece.algo.lc_201_250.lc240_searchMatrix;

/**
 * O(M+N)
 *
 * @author lazycece
 * @date 2022/8/3
 */
public class Lc240SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 确定大小分界线
        int i = m - 1;
        for (int j = 0; j < n; j++) {
            if (i < 0) break;
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) continue;
            else {
                i--;
                j--;
            }
        }
        return false;
    }
}
