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

package com.lazycece.algo.lc_701_750.lc739_dailyTemperatures;

import com.lazycece.utils.ArrayUtils;

/**
 * @author lazycece
 * @date 2022/7/7
 */
public class Lc739DailyTemperatures3 {

    public int[] dailyTemperatures(int[] temperatures) {

        // f(n) = (n+1) - n : if f(n+1> f(n)
        //      = fn(n+1) - n: if f(f(n+1)) > f(n)

        int len = temperatures.length;
        int[] res = new int[len];
        if (len == 0) return res;
        res[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            int r = i + 1;
            while (temperatures[r] <= temperatures[i]) {
                if (res[r] == 0) {
                    break;
                }
                r += res[r];
            }
            if (temperatures[r] > temperatures[i]) {
                res[i] = r - i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc739DailyTemperatures3 lc = new Lc739DailyTemperatures3();
//        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] t = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        ArrayUtils.print(lc.dailyTemperatures(t));
    }
}
