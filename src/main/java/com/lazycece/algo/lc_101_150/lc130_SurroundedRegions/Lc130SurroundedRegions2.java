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

package com.lazycece.algo.lc_101_150.lc130_SurroundedRegions;

/**
 * 利用题目特殊信息:任何边界上的 'O' 都不会被填充为 'X'
 * 先着色不能被包围的信息
 * 反向思路解题
 *
 * @author lazycece
 * @date 2022/8/13
 */
public class Lc130SurroundedRegions2 {
    int m, n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        // 利用题目特殊信息:任何边界上的 'O' 都不会被填充为 'X'
        // 先着色不能被包围的信息
        // 反向解题
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'F') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (board[i][j] == 'X' || board[i][j] == 'F') return;
        board[i][j] = 'F';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }


}
