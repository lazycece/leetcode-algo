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

package com.lazycece.algo.lc_1_50.lc7_ReverseInteger;

/**
 * 数字求余反转
 *
 * @author lazycece
 * @date 2022/3/6
 */
public class Lc7ReverseInteger {

    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            int t = x % 10;
            n = n * 10 + t;
            x = x / 10;
        }
        if (n < Integer.MIN_VALUE || n > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) n;
    }

    public static void main(String[] args) {
        Lc7ReverseInteger lc7 = new Lc7ReverseInteger();
        System.out.println(lc7.reverse(123));
        System.out.println(lc7.reverse(-123));
        System.out.println(lc7.reverse(-1230));
    }
}
