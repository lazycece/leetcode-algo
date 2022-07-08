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

package com.lazycece.algo.lc_51_100.lc79_wordSearch;

import javafx.util.Pair;

import java.util.Stack;

/**
 * @author lazycece
 * @date 2022/7/6
 */
public class Lc79WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] ch = word.toCharArray();
        int[][] flag = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != ch[0]) {
                    continue;
                }
                Stack<Pair<Integer, Integer>> stack = new Stack<>();
                stack.add(new Pair<>(i, j));
                int k = 0;
                while (!stack.isEmpty()) {
                    Pair<Integer, Integer> pair = stack.pop();
                    if (pair != null) {
                        int x = pair.getKey();
                        int y = pair.getValue();
                        if (board[x][y] != ch[k]) continue;
                        k++;
                        if (k == word.length()) return true;
                        flag[x][y] = 1;
                        stack.add(pair);
                        stack.add(null);
                        if (x - 1 >= 0 && flag[x - 1][y] != 1) {
                            stack.add(new Pair<>(x - 1, y));
                        }
                        if (y - 1 >= 0 && flag[x][y - 1] != 1) {
                            stack.add(new Pair<>(x, y - 1));
                        }
                        if (x + 1 < m && flag[x + 1][y] != 1) {
                            stack.add(new Pair<>(x + 1, y));
                        }
                        if (y + 1 < n && flag[x][y + 1] != 1) {
                            stack.add(new Pair<>(x, y + 1));
                        }
                    } else {
                        pair = stack.pop();
                        int x = pair.getKey();
                        int y = pair.getValue();
                        flag[x][y] = 0;
                        k--;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Lc79WordSearch lc = new Lc79WordSearch();
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "SEE";
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "SEE";
//        String word = "ABCCED";
//        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
//        String word = "AAB";
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
//        char[][] board = {{'A', 'B'}, {'C', 'D'}};
//        String word = "ABCD";
        System.out.println(lc.exist(board, word));

    }
}
