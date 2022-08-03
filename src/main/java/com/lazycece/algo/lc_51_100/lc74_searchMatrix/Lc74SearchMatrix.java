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

package com.lazycece.algo.lc_51_100.lc74_searchMatrix;

/**
 * @author lazycece
 * @date 2022/8/3
 */
public class Lc74SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = m - 1;
        while (row >= 0) {
            if (matrix[row][0] == target) return true;
            else if (matrix[row][0] < target) break;
            else row--;
        }
        if (row < 0) return false;
        int l = 1, r = n - 1;
        if (matrix[row][r] == target) return true;
        if (matrix[row][r] < target) return false;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
