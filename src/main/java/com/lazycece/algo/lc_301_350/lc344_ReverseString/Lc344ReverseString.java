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

package com.lazycece.algo.lc_301_350.lc344_ReverseString;

import com.lazycece.utils.ArrayUtils;

/**
 * @author lazycece
 * @date 2022/6/15
 */
public class Lc344ReverseString {

    public void reverseString(char[] s) {
        // 双指针
        int l = 0, r = s.length - 1;
        while (l < r) {
            char t = s[l];
            s[l++] = s[r];
            s[r--] = t;
        }
    }

    public static void main(String[] args) {
        Lc344ReverseString lc = new Lc344ReverseString();
        char[] ch = {'h', 'e', 'l', 'l', 'o' };
        lc.reverseString(ch);
        ArrayUtils.print(ch);

        char[] ch1 = {'H', 'a', 'n', 'n', 'a', 'h' };
        lc.reverseString(ch1);
        ArrayUtils.print(ch1);
    }
}
