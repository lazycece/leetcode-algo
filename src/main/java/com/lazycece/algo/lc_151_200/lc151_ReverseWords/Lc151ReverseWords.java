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

package com.lazycece.algo.lc_151_200.lc151_ReverseWords;

/**
 * @author lazycece
 * @date 2022/6/16
 */
public class Lc151ReverseWords {

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int l, r;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                l = i;
                while (i < arr.length && arr[i] != ' ') {
                    i++;
                }
                i--;
                r = i;
                reverse(arr, l, r);
            }
        }

        // 先去两端空格
        l = 0;
        r = arr.length - 1;
        while (l <= r && arr[l] == ' ') {
            l++;
        }
        while (r >= l && arr[r] == ' ') {
            r--;
        }
        // 再去内部空格
        StringBuilder sb = new StringBuilder();
        for (int i = l; i <= r; i++) {
            if (arr[i] != ' ') {
                sb.append(arr[i]);
            } else {
                sb.append(' ');
                while (arr[i] == ' ') {
                    i++;
                }
                i--;
            }
        }
        return sb.toString();
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char t = arr[l];
            arr[l++] = arr[r];
            arr[r--] = t;
        }
    }

    public static void main(String[] args) {
        Lc151ReverseWords lc = new Lc151ReverseWords();
        System.out.println(lc.reverseWords("the sky is blue"));
        System.out.println(lc.reverseWords("  hello world  "));
        System.out.println(lc.reverseWords("a good   example"));

    }
}
