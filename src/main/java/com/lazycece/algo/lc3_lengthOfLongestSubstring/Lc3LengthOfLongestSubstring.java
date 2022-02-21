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

import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度O(N),空间复杂度O(N)
 *
 * @author lazycece
 * @date 2022/2/21
 */
public class Lc3LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        // abcabcbb
        int max = 0;
        int left = 0;
        int i = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        //abca bcbb
        //a b ca bcbb
        for (; i < arr.length; i++) {
            if (map.containsKey(arr[i]) && map.get(arr[i]) >= left) {
                max = Math.max(max, i - 1 - left + 1);
                left = map.get(arr[i]) + 1;
            }
            map.put(arr[i], i);
        }
        // 考虑边界情况
        return Math.max(max, i - 1 - left + 1);
    }

    public static void main(String[] args) {
        Lc3LengthOfLongestSubstring lc3 = new Lc3LengthOfLongestSubstring();
//        String str = "abcabcbb";
//        String str = "bbbbb";
//        String str = "pwwkew";
//        String str = "";
        String str = "A";
        System.out.println(lc3.lengthOfLongestSubstring(str));
    }
}
