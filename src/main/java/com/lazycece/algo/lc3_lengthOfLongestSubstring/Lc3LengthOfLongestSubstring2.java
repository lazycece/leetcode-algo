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

package com.lazycece.algo.lc3_lengthOfLongestSubstring;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author lazycece
 * @date 2022/2/21
 */
public class Lc3LengthOfLongestSubstring2 {

    public int lengthOfLongestSubstring(String s) {
        if (" ".equals(s)) {
            return 1;
        }
        int max = 0;
        Queue<Character> queue = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (queue.contains(ch)) {
                int size = queue.size();
                max = Math.max(max, size);
                char temp = queue.remove();
                while (temp != ch) {
                    temp = queue.remove();
                }
            }
            queue.add(ch);
        }
        return Math.max(max, queue.size());
    }
}
