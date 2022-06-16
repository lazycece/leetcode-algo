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

package com.lazycece.algo.jzoffer.jz05_Tihuankongge;

/**
 * @author lazycece
 * @date 2022/6/16
 */
public class Jz05Tihuankongge2 {

    public String replaceSpace(String s) {
        char[] arr = s.toCharArray();
        int n = 0;
        // 假设全部是空格
        char[] a = new char[arr.length * 3];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                a[n++] = '%';
                a[n++] = '2';
                a[n++] = '0';
            } else {
                a[n++] = arr[i];
            }
        }
        return new String(a, 0, n);
    }

    public static void main(String[] args) {
        Jz05Tihuankongge2 jz = new Jz05Tihuankongge2();
        System.out.println(jz.replaceSpace("We are happy."));
    }
}
