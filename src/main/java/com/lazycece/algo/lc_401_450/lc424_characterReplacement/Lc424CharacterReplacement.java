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
public class Lc424CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] arr = new int[26];
        int l = 0;
        int i = 0;
        int max = 0;
        for (; i < n; i++) {
            arr[s.charAt(i) - 'A']++;
            // l-i这个滑动窗口中最多的字母
            max = Math.max(max, arr[s.charAt(i) - 'A']);
            if (i - l + 1 - max > k) {
                //如果s.charAt(l) - 'A' 时max的元素，这里也不需要考虑对max重新计算
                // 因为arr[s.charAt(l) - 'A']--;做了减法，后续的max计算时即便遇到同字符
                // 会出现 max= arr[s.charAt(i) - 'A']
                // 如果遇到非同字符，即其他字符，最终也一定会直接走到该区域，因为max其实计算了窗口内最大的数直接影响结论
                arr[s.charAt(l) - 'A']--;
                l++;
            }
        }
        return i - l;
    }
}
