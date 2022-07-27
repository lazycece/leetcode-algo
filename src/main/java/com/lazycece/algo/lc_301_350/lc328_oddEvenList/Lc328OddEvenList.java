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

package com.lazycece.algo.lc_301_350.lc328_oddEvenList;

import com.lazycece.model.ListNode;

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/7/27
 */
public class Lc328OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        // write code here
        ListNode lRoot = new ListNode(0);
        ListNode rRoot = new ListNode(0);
        ListNode l = lRoot, r = rRoot, p = head;

        int i = 1;
        while (p != null) {
            if (i % 2 == 0) {
                r.next = p;
                r = r.next;
            } else {
                l.next = p;
                l = l.next;
            }
            p = p.next;
            i++;
        }

        l.next = rRoot.next;
        r.next = null;

        return lRoot.next;
    }

    public static void main(String[] args) {
        Lc328OddEvenList lc = new Lc328OddEvenList();
        ListNode t = lc.oddEvenList(ListNode.build(Arrays.asList(1, 2, 3, 4, 5)));
        ListNode.print(t);
    }
}
