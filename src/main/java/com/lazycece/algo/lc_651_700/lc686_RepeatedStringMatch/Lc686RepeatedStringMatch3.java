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

package com.lazycece.algo.lc_651_700.lc686_RepeatedStringMatch;

/**
 * @author lazycece
 * @date 2022/6/24
 */
public class Lc686RepeatedStringMatch3 {

    public int repeatedStringMatch(String a, String b) {
        StringBuilder str = new StringBuilder(a);
        int i = 1;
        int max = 2 * a.length() + b.length();
        while (str.length() < max) {
            if (str.toString().contains(b)) return i;
            i++;
            str.append(a);
        }
        return -1;
    }

    public static void main(String[] args) {
        Lc686RepeatedStringMatch3 lc = new Lc686RepeatedStringMatch3();
        System.out.println(lc.repeatedStringMatch("abcd", "cdabcdab"));
    }
}
