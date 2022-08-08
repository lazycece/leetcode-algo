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

package com.lazycece.algo.lc_651_700.lc680_validPalindrome;

/**
 * 两边归中法，不能用中心扩散法
 *
 * @author lazycece
 * @date 2022/8/8
 */
public class Lc680ValidPalindrome {
    public boolean validPalindrome(String s) {
        int n = s.length();
        if (n == 0) return true;
        int l = 0, r = n - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) break;
            l++;
            r--;
        }
        if (l < r) {
            return helper(s, l + 1, r) || helper(s, l, r - 1);
        }
        return true;
    }

    private boolean helper(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
