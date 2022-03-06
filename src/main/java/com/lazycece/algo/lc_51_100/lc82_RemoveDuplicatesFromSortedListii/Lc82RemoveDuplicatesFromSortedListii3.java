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

package com.lazycece.algo.lc_51_100.lc82_RemoveDuplicatesFromSortedListii;

import com.lazycece.model.ListNode;

import java.util.Arrays;

/**
 * 以前驱节点指针为基础, 寻找后继节点的思路;空间复杂度O(1),时间复杂度O(n)
 *
 * @author lazycece
 * @date 2022/2/26
 */
public class Lc82RemoveDuplicatesFromSortedListii3 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode root = new ListNode(0, head);
        ListNode p = root;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int num = p.next.val;
                while (p.next != null && num == p.next.val) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        Lc82RemoveDuplicatesFromSortedListii3 lc82 = new Lc82RemoveDuplicatesFromSortedListii3();
        ListNode.print(lc82.deleteDuplicates(ListNode.build(Arrays.asList(1, 2, 3, 3, 4, 4, 5))));
        ListNode.print(lc82.deleteDuplicates(ListNode.build(Arrays.asList(1, 1, 1, 2, 3))));
        ListNode.print(lc82.deleteDuplicates(ListNode.build(Arrays.asList(1, 2, 3, 3, 4, 4))));
        ListNode.print(lc82.deleteDuplicates(ListNode.build(Arrays.asList(1, 1, 2, 2))));
    }
}
