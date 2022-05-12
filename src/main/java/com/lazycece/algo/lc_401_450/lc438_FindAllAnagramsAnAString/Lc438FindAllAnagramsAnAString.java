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
 * 如果窗口大小可以控制，则可以使用该方式
 *
 * @author lazycece
 * @date 2022/5/6
 */
public class Lc438FindAllAnagramsAnAString {

    public List<Integer> findAnagrams(String s, String p) {
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        List<Character> list = new ArrayList<>();
        Arrays.sort(chp);
        String p1 = Arrays.toString(chp);
        List<Integer> inList = new ArrayList<>();
        int l = 0, r = 0;
        for (; r < chs.length; r++) {
            list.add(chs[r]);
            if (list.size() == chp.length) {
                List<Character> t = new ArrayList<>(list);
                Collections.sort(t);
                if (p1.equals(t.toString())) {
                    inList.add(l);
                }
                list.remove(0);
                l++;
            }
        }
        return inList;
    }

    public static void main(String[] args) {
        Lc438FindAllAnagramsAnAString lc = new Lc438FindAllAnagramsAnAString();
        System.out.println(lc.findAnagrams("cbaebabacd", "abc"));
        System.out.println(lc.findAnagrams("abab", "ab"));
    }
}
