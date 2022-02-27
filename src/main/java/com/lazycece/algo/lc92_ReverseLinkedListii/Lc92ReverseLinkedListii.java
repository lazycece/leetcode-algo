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

package com.lazycece.algo.lc92_ReverseLinkedListii;

import com.lazycece.model.ListNode;

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/2/27
 */
public class Lc92ReverseLinkedListii {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode root = new ListNode(0, head);
        ListNode p = root, pre = null;
        int n = 1;
        while (p.next != null) {
            if (n == left) {
                pre = p;
                ListNode tail = p.next, l = null;
                p = p.next;
                // 双指针思路
                while (p.next != null && ++n <= right) {
                    ListNode t = p.next;
                    p.next = l;
                    l = p;
                    p = t;
                }
                tail.next = p.next;
                if (p != tail) {
                    // 注意p = 尾指针的情况
                    p.next = l;
                }
                pre.next = p;
            } else {
                n++;
                p = p.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        Lc92ReverseLinkedListii lc92 = new Lc92ReverseLinkedListii();

        ListNode.print(lc92.reverseBetween(
                ListNode.build(Arrays.asList(1, 2, 3, 4, 5)),
                2,
                4
        ));
        ListNode.print(lc92.reverseBetween(
                ListNode.build(Arrays.asList(5)),
                1,
                1
        ));
        ListNode.print(lc92.reverseBetween(
                ListNode.build(Arrays.asList(1, 5)),
                2,
                2
        ));
        ListNode.print(lc92.reverseBetween(
                ListNode.build(Arrays.asList(1, 5)),
                1,
                1
        ));
    }
}
