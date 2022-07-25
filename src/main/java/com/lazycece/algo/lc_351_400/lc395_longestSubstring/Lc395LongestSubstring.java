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

package com.lazycece.algo.lc_351_400.lc395_longestSubstring;

/**
 * 递归，分治
 *
 * @author lazycece
 * @date 2022/7/23
 */
public class Lc395LongestSubstring {

    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n < k) return 0;
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        char split = '0';
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0 && arr[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }

        if (split == '0') return n;

        int l = 0, r = n - 1;
        int i = l;
        int res = 0;
        while (l < r) {
            while (i <= r && s.charAt(i) != split) {
                i++;
            }
            int len = longestSubstring(s.substring(l, i), k);
            res = Math.max(len, res);
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            l = i;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc395LongestSubstring lc = new Lc395LongestSubstring();
        System.out.println(lc.longestSubstring("aaabb", 3));
        System.out.println(lc.longestSubstring("ababbc", 2));
    }
}
