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

package com.lazycece.algo.lc_51_100.lc76_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 *
 * @author lazycece
 * @date 2022/4/27
 */
public class Lc76MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = t.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            tMap.put(arr[i], tMap.getOrDefault(arr[i], 0) + 1);
        }
        char[] ch = s.toCharArray();
        int li = -1, ri = -1;
        int len = Integer.MAX_VALUE;
        int l = 0, r = 0;
        for (; r < ch.length; r++) {
            map.put(ch[r], map.getOrDefault(ch[r], 0) + 1);
            while (check(tMap, map)) {
                int temp = r - l + 1;
                if (len > temp) {
                    len = temp;
                    li = l;
                    ri = r;
                }
                map.put(ch[l], map.get(ch[l]) - 1);
                if (map.get(ch[l]) == 0) {
                    map.remove(ch[l]);
                }
                l++;
            }
        }
        return li == -1 ? "" : s.substring(li, ri + 1);
    }

    private boolean check(Map<Character, Integer> tMap, Map<Character, Integer> map) {
        if (tMap.size() > map.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            // 不小于
            if (map.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Lc76MinimumWindowSubstring lc = new Lc76MinimumWindowSubstring();
        System.out.println(lc.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(lc.minWindow("a", "a"));
        System.out.println(lc.minWindow("a", "aa"));

    }
}
