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

package com.lazycece.algo.lc_51_100.lc59_SpiralMatrixii;

import com.lazycece.utils.ArrayUtils;

/**
 * n=3: loop = 1, 中点=true
 * 1,  2, _3
 * _8  *9*  4
 * 7_, 6,  5_
 * <p>
 * --
 * n=4: loop = 2, 中点=false
 * 1,    2,  3,  _4
 * 12, _13, _14, 5
 * 11, _16 ,_15, 6
 * _10, 9,   8, _7
 *
 * @author lazycece
 * @date 2022/4/28
 */
public class Lc59SpiralMatrixii {

    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int loop = n / 2;
        int x = 0, y = 0;
        int cnt = 1;
        while (loop-- > 0) {
            int j = x, i = y;
            // to right
            for (; j < n - y - 1; j++) {
                m[i][j] = cnt++;
            }
            // to down
            for (; i < n - x - 1; i++) {
                m[i][j] = cnt++;
            }
            // to left
            for (; j > x; j--) {
                m[i][j] = cnt++;
            }
            // to up
            for (; i > y; i--) {
                m[i][j] = cnt++;
            }
            x++;
            y++;
        }
        // n=奇数时处理中心位置
        if (n % 2 != 0) {
            m[x][y] = cnt;
        }
        return m;
    }

    public static void main(String[] args) {
        Lc59SpiralMatrixii lc = new Lc59SpiralMatrixii();
        ArrayUtils.print(lc.generateMatrix(3));
        ArrayUtils.print(lc.generateMatrix(4));
        ArrayUtils.print(lc.generateMatrix(5));
        ArrayUtils.print(lc.generateMatrix(1));

    }
}
