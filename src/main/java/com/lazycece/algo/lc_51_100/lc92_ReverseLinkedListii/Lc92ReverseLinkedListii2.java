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

package com.lazycece.algo.lc_51_100.lc92_ReverseLinkedListii;

import com.lazycece.model.ListNode;

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/2/27
 */
public class Lc92ReverseLinkedListii2 {


    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode root = new ListNode(0);
        root.next = head;
        int i = 1;
        ListNode p = head, pre = root;
        while (p != null) {
            if (i == m) {
                ListNode tail = p;
                ListNode l = null;
                while (i < n) {
                    ListNode t = p.next;
                    p.next = l;
                    l = p;
                    p = t;
                    i++;
                }
                tail.next = p.next;
                if (p != tail) {
                    p.next = l;
                }
                break;
            } else {
                pre = p;
                p = p.next;
                i++;
            }
        }
        pre.next = p;
        return root.next;
    }

    public static void main(String[] args) {
        Lc92ReverseLinkedListii2 lc92 = new Lc92ReverseLinkedListii2();

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
