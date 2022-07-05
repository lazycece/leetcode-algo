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

package com.lazycece.algo.lc_501_550.lc509_FibonacciNumber;

/**
 * dp 思路
 *
 * @author lazycece
 * @date 2022/7/5
 */
public class Lc509FibonacciNumber3 {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int l = 0;
        int r = 1;
        // 只需要维护两个数
        for (int i = 2; i < n; i++) {
            int num = l + r;
            l = r;
            r = num;
        }
        return l + r;
    }
}
