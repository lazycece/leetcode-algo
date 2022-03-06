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

package com.lazycece.algo.lc_1_50.lc9_PalindromeNumber;

/**
 * 整数求余反转判断是否相等
 *
 * @author lazycece
 * @date 2022/3/6
 */
public class Lc9PalindromeNumber {

    public boolean isPalindrome(int x) {
        // 排除已知case
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        long n = 0, m = x;
        while (m != 0) {
            long t = m % 10;
            m = m / 10;
            n = n * 10 + t;
        }
        return n == x;
    }

    public static void main(String[] args) {
        Lc9PalindromeNumber lc9 = new Lc9PalindromeNumber();
        System.out.println(lc9.isPalindrome(121));
        System.out.println(lc9.isPalindrome(-12));
        System.out.println(lc9.isPalindrome(-121));
        System.out.println(lc9.isPalindrome(1210));
    }
}
