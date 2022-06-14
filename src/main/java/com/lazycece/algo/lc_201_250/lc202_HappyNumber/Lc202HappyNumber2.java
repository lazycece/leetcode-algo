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
 * 时间复杂度：O(log n)O(logn)
 * 空间复杂度：O(1)O(1)
 * @author lazycece
 * @date 2022/6/10
 */
public class Lc202HappyNumber2 {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        // 寻找1，并判断循环 --- 快慢指针,隐形链表寻找环思路
        while (slow != 1 && slow!=fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return slow == 1;
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
        Lc202HappyNumber2 lc = new Lc202HappyNumber2();
        System.out.println(lc.isHappy(19));
        System.out.println(lc.isHappy(2));
    }
}
