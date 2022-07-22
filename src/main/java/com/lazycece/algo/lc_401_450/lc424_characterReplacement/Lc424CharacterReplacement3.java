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
 * 如下解释摘子leetcode评论：
 * 
 * 每轮循环的窗口大小都是比最长序列长度大一,是要你去测试这个窗口长度是否可行，
 * 而charMax是记录的历史最大值，如果出现最多的字符被移除，那么不管下一轮新
 * 加入窗口的字符是不是出现最多的字符，他都不能保证right - left + 1 <= charMax + k。
 * 我们考虑什么时候窗口长度加一，肯定是移除的字符不是出现最多的，但是新加入
 * 的字符是出现最多的这种情况，而新加入窗口的字符是出现最多的字符时，其实已经
 * 通过map[index]把charMax给更新了，这样就足以来判断窗口长度是否加一。
 * By the way，我觉得加上if(map[chars[left] - 'A'] == charMax) charMax--;，可能会更好理解。\
 *
 * @author lazycece
 * @date 2022/7/22
 */
public class Lc424CharacterReplacement3 {

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
                if (arr[s.charAt(l) - 'A'] == max) max--;
                arr[s.charAt(l) - 'A']--;
                l++;
            }
        }
        return i - l;
    }
}
