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

package com.lazycece.algo.lc_501_550.lc541_ReverseStringii;

/**
 * @author lazycece
 * @date 2022/6/15
 */
public class Lc541ReverseStringii2 {

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            reverse(arr, i, Math.min(arr.length - 1, i + k - 1));
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char t = arr[l];
            arr[l++] = arr[r];
            arr[r--] = t;
        }
    }

    public static void main(String[] args) {
        Lc541ReverseStringii2 lc = new Lc541ReverseStringii2();
        System.out.println(lc.reverseStr("abcdefg", 2));
        System.out.println(lc.reverseStr("abcd", 2));

    }
}
