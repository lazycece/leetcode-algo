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
 * 数字求余反转, 但因不能使用64为符号集,即不能使用long型
 * <p>
 * -2147483648 = -2^31 <= x <= 2^31 - 1 = 2147483647
 * 即最后一位值  -8<= x <= 7
 *
 * @author lazycece
 * @date 2022/3/6
 */
public class Lc7ReverseInteger3 {

    public int reverse(int x) {
        int number = 0;
        while (x != 0) {
            int temp = x % 10;
            x /= 10;
            if (number > Integer.MAX_VALUE / 10 || (number == Integer.MAX_VALUE / 10 && temp > 7))
                return 0;
            if (number < Integer.MIN_VALUE / 10 || (number == Integer.MIN_VALUE / 10 && temp < -8))
                return 0;
            number = number * 10 + temp;
        }
        return number;
    }

    public static void main(String[] args) {
        Lc7ReverseInteger3 lc7 = new Lc7ReverseInteger3();
        System.out.println(lc7.reverse(123));
        System.out.println(lc7.reverse(-123));
        System.out.println(lc7.reverse(-1230));
    }
}
