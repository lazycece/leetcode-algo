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

package com.lazycece.algo.lc_1_50.lc49_GroupAnagrams;

import com.lazycece.utils.ArrayUtils;

import java.util.*;

/**
 * @author lazycece
 * @date 2022/5/6
 */
public class Lc49GroupAnagrams2 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            int[] in = new int[26];
            for (char i : ch) {
                in[i - 'a']++;
            }
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < in.length; j++) {
                if (in[j] != 0) {
                    s.append((char) ('a' + j));
                    s.append(in[j]);
                }
            }
            String key = s.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Lc49GroupAnagrams2 lc = new Lc49GroupAnagrams2();
        ArrayUtils.print(lc.groupAnagrams(strs));
        ArrayUtils.print(lc.groupAnagrams(new String[]{""}));
    }
}
