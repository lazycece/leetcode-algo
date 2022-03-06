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

/***
 * 以当前指针为基础, 寻找后继节点的思路,前驱节点链接后继节点;空间复杂度O(1),时间复杂度O(n)
 *
 * @author lazycece
 * @date 2022/2/26
 */
public class Lc82RemoveDuplicatesFromSortedListii2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode p = start.next, pre = start;
        int val = 0;
        while (p != null && p.next != null) {
            if (p.val != p.next.val) {
                if (pre.next != p) {
                    pre.next = p.next;
                } else {
                    pre.next = p;
                    pre = pre.next;
                }
            } else {
                val = p.val;
            }
            p = p.next;
        }

        if (p != pre.next) {
            if (val != p.val) {
                pre.next = p;
            } else {
                pre.next = null;
            }
        }
        return start.next;

    }

    public static void main(String[] args) {
        Lc82RemoveDuplicatesFromSortedListii2 lc82 = new Lc82RemoveDuplicatesFromSortedListii2();
        ListNode.print(lc82.deleteDuplicates(ListNode.build(Arrays.asList(1, 2, 3, 3, 4, 4, 5))));
        ListNode.print(lc82.deleteDuplicates(ListNode.build(Arrays.asList(1, 1, 1, 2, 3))));
        ListNode.print(lc82.deleteDuplicates(ListNode.build(Arrays.asList(1, 2, 3, 3, 4, 4))));
        ListNode.print(lc82.deleteDuplicates(ListNode.build(Arrays.asList(1, 1, 2, 2))));
    }
}
