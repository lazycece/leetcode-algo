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

package com.lazycece.algo.lc_1001_1050.lc1002_FindCommonCharacters;

import java.util.ArrayList;
import java.util.List;

/**
 * 每个字符串中都需要存在，包含重复字符，
 * 即寻找目标字符在每个字符串中的最小数量
 *
 * @author lazycece
 * @date 2022/5/14
 */
public class Lc1002FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        if (words.length <= 1) {
            return list;
        }
        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 101;
        }
        for (String wor : words) {
            int[] a = new int[26];
            for (Character ch : wor.toCharArray()) {
                a[ch - 'a']++;
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Math.min(arr[i], a[i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int l = arr[i];
            if (l == 101) {
                continue;
            }
            while (l-- > 0) {
                char ch = (char) (i + 'a');
                list.add(Character.toString(ch));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Lc1002FindCommonCharacters lc = new Lc1002FindCommonCharacters();
        System.out.println(lc.commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(lc.commonChars(new String[]{"cool", "lock", "cook"}));
    }
}
