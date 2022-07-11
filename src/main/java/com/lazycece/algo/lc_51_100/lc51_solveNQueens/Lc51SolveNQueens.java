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

package com.lazycece.algo.lc_51_100.lc51_solveNQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/7/11
 */
public class Lc51SolveNQueens {

    private int[][] matrix;
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return res;
        matrix = new int[n][n];
        helper(0, n);
        return res;
    }

    private void helper(int k, int n) {
        if (k == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < n; j++) {
                    String t = matrix[i][j] == 1 ? "Q" : ".";
                    str = str + t;
                }
                list.add(str);
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (k == 0 || match(i, k, n)) {
                matrix[i][k] = 1;
                helper(k + 1, n);
                matrix[i][k] = 0;
            }
        }
    }

    //  按照从左向右的顺序将Q放置再数组列上
    //  第一列，可以从第0个到第n-1个的放置方式尝试

    private boolean match(int row, int column, int n) {
        // 横向列判断
        int j = column - 1;
        while (j >= 0) {
            if (matrix[row][j] == 1) return false;
            j--;
        }
        // 左上斜向判断
        int i = row - 1;
        j = column - 1;
        while (i >= 0 && j >= 0) {
            if (matrix[i][j] == 1) return false;
            i--;
            j--;
        }
        // 左下斜向判断
        i = row + 1;
        j = column - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == 1) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Lc51SolveNQueens lc = new Lc51SolveNQueens();
//        System.out.println(lc.solveNQueens(4));
        System.out.println(lc.solveNQueens(5));

    }
}
