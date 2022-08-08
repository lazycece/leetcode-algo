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

package com.lazycece.algo.lc_101_150.lc125_isPalindrome;

/**
 * @author lazycece
 * @date 2022/8/8
 */
public class Lc125IsPalindrome {

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char lch = s.charAt(l);
            char rch = s.charAt(r);
            if (!Character.isLetterOrDigit(lch)) {
                l++;
                continue;
            }
            lch = Character.toLowerCase(lch);
            if (!Character.isLetterOrDigit(rch)) {
                r--;
                continue;
            }
            rch = Character.toLowerCase(rch);
            if (lch != rch) return false;
            l++;
            r--;
        }
        return true;
    }
}
