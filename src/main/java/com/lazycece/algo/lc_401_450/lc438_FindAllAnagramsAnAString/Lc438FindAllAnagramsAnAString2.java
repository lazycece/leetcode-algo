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

package com.lazycece.algo.lc_401_450.lc438_FindAllAnagramsAnAString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 窗口大小无法控制，只有小写字母，可以用数组字典
 *
 * @author lazycece
 * @date 2022/5/6
 */
public class Lc438FindAllAnagramsAnAString2 {

    public List<Integer> findAnagrams(String s, String p) {
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        int[] in = new int[26];
        for (char i : chp) {
            in[i - 'a']++;
        }
        List<Integer> inList = new ArrayList<>();
        int l = 0, r = 0;
        for (; r < chs.length; r++) {
            if (in[chs[r] - 'a'] > 0) {
                // 遇到一个扣减一个
                in[chs[r] - 'a']--;
                if (r - l + 1 == chp.length) {
                    inList.add(l);
                }
            } else {
                // 在没遇到的时候则恢复之前扣减的
                in[chs[l++] - 'a']++;
                r--;
            }
        }
        return inList;
    }


    public static void main(String[] args) {
        Lc438FindAllAnagramsAnAString2 lc = new Lc438FindAllAnagramsAnAString2();
        System.out.println(lc.findAnagrams("cbaeebabacd", "abc"));

        System.out.println(lc.findAnagrams("cbaebabacd", "abc"));
        System.out.println(lc.findAnagrams("abab", "ab"));
    }
}
