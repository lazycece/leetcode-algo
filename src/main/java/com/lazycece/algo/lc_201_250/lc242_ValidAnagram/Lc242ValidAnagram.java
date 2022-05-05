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

package com.lazycece.algo.lc_201_250.lc242_ValidAnagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author lazycece
 * @date 2022/5/6
 */
public class Lc242ValidAnagram {

    public boolean isAnagram(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Map<Character, Integer> maps = new HashMap<>();
        Map<Character, Integer> mapt = new HashMap<>();
        for (char ch : chs) {
            maps.put(ch, maps.getOrDefault(ch, 0) + 1);
        }
        for (char c : cht) {
            mapt.put(c, mapt.getOrDefault(c, 0) + 1);
        }
        if (maps.size() != mapt.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : maps.entrySet()) {
            if (!Objects.equals(entry.getValue(), mapt.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Lc242ValidAnagram lc = new Lc242ValidAnagram();
        System.out.println(lc.isAnagram("anagram", "nagaram"));
        System.out.println(lc.isAnagram("rat", "car"));

    }
}
