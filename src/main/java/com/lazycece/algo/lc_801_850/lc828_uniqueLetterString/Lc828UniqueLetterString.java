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

package com.lazycece.algo.lc_801_850.lc828_uniqueLetterString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字符串贡献问题
 *
 * @author lazycece
 * @date 2022/9/6
 */
public class Lc828UniqueLetterString {

    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new ArrayList<>());
                map.get(ch).add(-1);
            }
            map.get(ch).add(i);
        }

        int res = 0;
        for (Map.Entry<Character, List<Integer>> en : map.entrySet()) {
            List<Integer> list = en.getValue();
            list.add(s.length());
            for (int i = 1; i < list.size() - 1; i++) {
                // 距离的可能性计算: 在包含i的情况下，向右的可能性数量 乘以 向左的可能性数量
                res += (list.get(i) - list.get(i - 1)) * (list.get(i + 1) - list.get(i));
            }
        }
        return res;
    }
}
