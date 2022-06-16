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
public class Jz05Tihuankongge {

    public String replaceSpace(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Jz05Tihuankongge jz = new Jz05Tihuankongge();
        System.out.println(jz.replaceSpace("We are happy."));
    }
}
