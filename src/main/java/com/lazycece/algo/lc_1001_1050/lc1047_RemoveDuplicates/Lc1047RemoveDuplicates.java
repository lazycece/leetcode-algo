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

package com.lazycece.algo.lc_1001_1050.lc1047_RemoveDuplicates;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lazycece
 * @date 2022/6/24
 */
public class Lc1047RemoveDuplicates {

    public String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (deque.isEmpty()) {
                deque.add(ch[i]);
            } else {
                char t = deque.getLast();
                if (t == ch[i]) {
                    deque.removeLast();
                } else {
                    deque.add(ch[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Lc1047RemoveDuplicates lc = new Lc1047RemoveDuplicates();
        System.out.println(lc.removeDuplicates("abbaca"));
    }
}
