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

package com.lazycece.algo.lc_351_400.lc383_RansomNote;

/**
 * @author lazycece
 * @date 2022/6/15
 */
public class Lc383RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 纯小写字母，利用哈希表思路
        int[] arr = new int[26];
        for (char a : ransomNote.toCharArray()) {
            arr[a - 'a']++;
        }
        for (char a : magazine.toCharArray()) {
            arr[a - 'a']--;
        }
        for (int i : arr) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
