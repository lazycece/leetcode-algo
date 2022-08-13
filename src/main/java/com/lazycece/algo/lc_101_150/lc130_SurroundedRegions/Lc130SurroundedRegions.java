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
 * dfs，先遍历，结果为true，则从头开始替换值，否则回滚着色信息
 *
 * @author lazycece
 * @date 2022/8/13
 */
public class Lc130SurroundedRegions {

    int m, n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (dfs(board, i, j)) {
                        dfsFill(board, i, j);
                    } else {
                        revert(board);
                    }
                }
            }
        }
    }

    // 回滚着色
    private void revert(char[][] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'F') board[i][j] = 'O';
            }
        }
    }

    // 值覆盖
    private void dfsFill(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (board[i][j] == 'X') return;
        board[i][j] = 'X';
        dfsFill(board, i - 1, j);
        dfsFill(board, i + 1, j);
        dfsFill(board, i, j - 1);
        dfsFill(board, i, j + 1);
    }

    private boolean dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (board[i][j] == 'X' || board[i][j] == 'F') return true;
        // 遍历着色
        board[i][j] = 'F';
        return dfs(board, i - 1, j) && dfs(board, i + 1, j)
                && dfs(board, i, j - 1) && dfs(board, i, j + 1);
    }
}
