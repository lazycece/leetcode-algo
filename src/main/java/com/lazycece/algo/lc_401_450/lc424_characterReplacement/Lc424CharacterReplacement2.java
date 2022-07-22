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

package com.lazycece.algo.lc_401_450.lc424_characterReplacement;

/**
 * @author lazycece
 * @date 2022/7/22
 */
public class Lc424CharacterReplacement2 {

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] arr = new int[26];
        int l = 0, i = 0, max = 0;
        int res = 0;
        int index = -1;
        for (; i < n; i++) {
            int t = s.charAt(i) - 'A';
            arr[t]++;
            if (max < arr[t]) {
                max = arr[t];
                index = t;
            }
            max = Math.max(max, arr[t]);
            if (i - l + 1 - max > k) {
                res = Math.max(res, max + k);
                arr[s.charAt(l) - 'A']--;
                if (index == s.charAt(l) - 'A') {
                    max--;
                }
                l++;
            }
        }
        res = Math.max(res, i - l);
        return res;
    }
}
