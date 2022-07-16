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

package com.lazycece.algo.lc_601_650.lc647_countSubstrings;

/**
 * 中心扩散法
 *
 * @author lazycece
 * @date 2022/7/16
 */
public class Lc647CountSubstrings2 {

    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }
            // 当i>0时，中心存在两种情况，i为中心，（i-1，i）为中心
            if (i > 0) {
                l = i - 1;
                r = i;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    res++;
                    l--;
                    r++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc647CountSubstrings2 lc = new Lc647CountSubstrings2();
        System.out.println(lc.countSubstrings("abc"));
    }
}
