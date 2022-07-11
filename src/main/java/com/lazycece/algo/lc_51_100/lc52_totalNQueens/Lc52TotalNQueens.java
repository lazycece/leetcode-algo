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

package com.lazycece.algo.lc_51_100.lc52_totalNQueens;

/**
 * @author lazycece
 * @date 2022/7/12
 */
public class Lc52TotalNQueens {

    private int[][] metric;
    private int res = 0;

    public int totalNQueens(int n) {
        if (n <= 0) return res;
        metric = new int[n][n];
        helper(0, n);
        return res;
    }

    private void helper(int k, int n) {
        if (k == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (k == 0 || match(i, k, n)) {
                metric[i][k] = 1;
                helper(k + 1, n);
                metric[i][k] = 0;
            }
        }
    }

    private boolean match(int row, int column, int n) {
        int j = column - 1;
        while (j >= 0) {
            if (metric[row][j] == 1) return false;
            j--;
        }
        j = column - 1;
        int i = row - 1;
        while (j >= 0 && i >= 0) {
            if (metric[i][j] == 1) return false;
            j--;
            i--;
        }
        j = column - 1;
        i = row + 1;
        while (j >= 0 && i < n) {
            if (metric[i][j] == 1) return false;
            j--;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Lc52TotalNQueens lc =new Lc52TotalNQueens();
        Lc52TotalNQueens lc2 =new Lc52TotalNQueens();
        Lc52TotalNQueens lc3 =new Lc52TotalNQueens();
        System.out.println(lc.totalNQueens(4));
        System.out.println(lc2.totalNQueens(5));
        System.out.println(lc3.totalNQueens(1));
    }
}
