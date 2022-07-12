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

package com.lazycece.algo.lc_1_50.lc37_solveSudoku;

/**
 * 递归遍历每一个空格进行填数
 *
 * @author lazycece
 * @date 2022/7/12
 */
public class Lc37SolveSudoku {

    public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (yes(board, i, j, k)) {
                        board[i][j] = k;
                        if (helper(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean yes(char[][] board, int i, int j, char k) {
        for (int x = 0; x < 9; x++) {
            if (board[x][j] == k) return false;
        }
        for (int y = 0; y < 9; y++) {
            if (board[i][y] == k) return false;
        }

        int bx = (i / 3) * 3;
        int by = (j / 3) * 3;
        for (int x = bx; x < bx + 3; x++) {
            for (int y = by; y < by + 3; y++) {
                if (board[x][y] == k) return false;
            }
        }
        return true;
    }

}
