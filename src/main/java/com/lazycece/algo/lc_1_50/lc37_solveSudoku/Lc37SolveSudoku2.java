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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 空间换时间
 *
 * @author lazycece
 * @date 2022/7/12
 */
public class Lc37SolveSudoku2 {

    private Map<String, Set<Character>> map = new HashMap<>();

    public void solveSudoku(char[][] board) {
        if (board.length != 9 && board[0].length != 9) return;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (map.get(rowKey(i)) == null) {
                    map.put(rowKey(i), new HashSet<>());
                }
                map.get(rowKey(i)).add(board[i][j]);
                if (map.get(columnKey(j)) == null) {
                    map.put(columnKey(j), new HashSet<>());
                }
                map.get(columnKey(j)).add(board[i][j]);
                if (map.get(metrixKey(i, j)) == null) {
                    map.put(metrixKey(i, j), new HashSet<>());
                }
                map.get(metrixKey(i, j)).add(board[i][j]);
            }
        }
        helper(board);
    }

    private String rowKey(int row) {
        return "row_" + row;
    }

    private String columnKey(int column) {
        return "column_" + column;
    }

    private String metrixKey(int i, int j) {
        if (i < 3 && j < 3)
            return "metrix_03_03";
        if (i < 3 && j >= 3 && j < 6)
            return "metrix_03_36";
        if (i < 3 && j >= 6 && j < 9)
            return "metrix_03_69";
        if (i >= 3 && i < 6 && j >= 0 && j < 3)
            return "metrix_36_03";
        if (i >= 3 && i < 6 && j >= 3 && j < 6)
            return "metrix_36_36";
        if (i >= 3 && i < 6 && j >= 6 && j < 9)
            return "metrix_36_69";
        if (i >= 6 && i < 9 && j < 3 && j >= 0)
            return "metrix_69_03";
        if (i >= 6 && i < 9 && j < 6 && j >= 3)
            return "metrix_69_36";
        if (i >= 6 && i < 9 && j < 9 && j >= 6)
            return "metrix_69_69";
        throw new IllegalArgumentException("param error");
    }

    private boolean yes(int i, int j, char k) {
        if (map.get(rowKey(i)) == null) {
            map.put(rowKey(i), new HashSet<>());
            return true;
        }
        if (map.get(rowKey(i)).contains(k))
            return false;

        if (map.get(columnKey(j)) == null) {
            map.put(columnKey(j), new HashSet<>());
            return true;
        }
        if (map.get(columnKey(j)).contains(k))
            return false;
        if (map.get(metrixKey(i, j)) == null) {
            map.put(metrixKey(i, j), new HashSet<>());
            return true;
        }
        if (map.get(metrixKey(i, j)).contains(k))
            return false;
        return true;
    }

    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (!yes(i, j, k)) continue;
                    map.get(rowKey(i)).add(k);
                    map.get(columnKey(j)).add(k);
                    map.get(metrixKey(i, j)).add(k);
                    board[i][j] = k;
                    if (helper(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                    map.get(rowKey(i)).remove(k);
                    map.get(columnKey(j)).remove(k);
                    map.get(metrixKey(i, j)).remove(k);
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Lc37SolveSudoku2 lc = new Lc37SolveSudoku2();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        lc.solveSudoku(board);
        System.out.println();
    }
}
