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

package com.lazycece.algo.lc_151_200.lc187_findRepeatedDnaSequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lazycece
 * @date 2022/7/19
 */
public class Lc187FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if (n <= 10) return res;
        Set<String> set = new HashSet<>();
        int l = 0;
        while (l + 10 <= n) {
            String temp = s.substring(l, l + 10);
            if (set.contains(temp) && !res.contains(temp)) {
                res.add(temp);
            }
            set.add(temp);
            l++;
        }
        return res;
    }
}
