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

package com.lazycece.algo.lc_551_600.lc556_nextGreaterElement;

/**
 * @author lazycece
 * @date 2022/8/17
 */
public class Lc556NextGreaterElement {

    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) return -1;
        for (int j = arr.length - 1; j > i; j--) {
            if (arr[j] > arr[i]) {
                char t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
                break;
            }
        }
        int j = arr.length - 1;
        i++;
        while (i < j) {
            char t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
            i++;
            j--;
        }
        long res = Long.parseLong(new String(arr));
        if (res > Integer.MAX_VALUE) return -1;
        return (int) res;
    }
}
