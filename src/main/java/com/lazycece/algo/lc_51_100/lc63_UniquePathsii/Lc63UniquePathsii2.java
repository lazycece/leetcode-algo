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

package com.lazycece.algo.lc_51_100.lc63_UniquePathsii;

/**
 * @author lazycece
 * @date 2022/7/6
 */
public class Lc63UniquePathsii2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j > 0 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Lc63UniquePathsii2 lc = new Lc63UniquePathsii2();
        int[][] arr = {
                {0, 1}
//                {0, 0}
        };
        System.out.println(lc.uniquePathsWithObstacles(arr));
    }
}
