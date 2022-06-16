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

package com.lazycece.algo.jzoffer.jz58_ReverseLeftWords;

/**
 * @author lazycece
 * @date 2022/6/16
 */
public class Jz58ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = n; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Jz58ReverseLeftWords jz = new Jz58ReverseLeftWords();
        System.out.println(jz.reverseLeftWords("abcdefg", 2));
        System.out.println(jz.reverseLeftWords("lrloseumgh", 6));
    }
}
