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

package com.lazycece.algo.lc_451_500.lc461_hammingDistance;

/**
 * @author lazycece
 * @date 2022/9/3
 */
public class Lc461HammingDistance2 {

    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int cnt = 0;
        while (temp != 0) {
            cnt += temp & 1;
            temp = temp >> 1;
        }
        return cnt;
    }
}
