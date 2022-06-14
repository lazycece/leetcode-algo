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

package com.lazycece.algo.lc_201_250.lc202_HappyNumber;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lazycece
 * @date 2022/6/10
 */
public class Lc202HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        // 寻找1，并判断循环
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int num = 0;
        while (n > 0) {
            num += (n % 10) * (n % 10);
            n = n / 10;
        }
        return num;
    }

    public static void main(String[] args) {
        Lc202HappyNumber lc = new Lc202HappyNumber();
        System.out.println(lc.isHappy(19));
        System.out.println(lc.isHappy(2));
    }
}
