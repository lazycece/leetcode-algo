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

package com.lazycece.algo.lc_201_250.lc234_isPalindrome;

import com.lazycece.model.ListNode;

/**
 * @author lazycece
 * @date 2022/8/8
 */
public class Lc234IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode pre = null, s = head, f = head;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            ListNode t = s.next;
            s.next = pre;
            pre = s;
            s = t;
        }

        if (f.next == null) {
            f = s.next;
            s = pre;
        } else {
            f = s.next;
            s.next = pre;
        }

        while (s != null && f != null) {
            if (s.val != f.val) return false;
            s = s.next;
            f = f.next;
        }
        return true;
    }
}
