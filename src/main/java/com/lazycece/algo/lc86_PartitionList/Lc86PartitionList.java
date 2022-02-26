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

package com.lazycece.algo.lc86_PartitionList;

import com.lazycece.model.ListNode;

import java.util.Arrays;

/**
 * 以前驱节点为基础, 对比后驱节点与目标值的情况,寻找后驱节点; 大于则在一个新的链表上关联指向关系
 *
 * @author lazycece
 * @date 2022/2/27
 */
public class Lc86PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode root = new ListNode(0, head);
        ListNode tail = new ListNode(0);
        ListNode p = root, l = tail;
        while (p.next != null) {
            if (p.next.val < x) {
                p = p.next;
            } else {
                l.next = p.next;
                l = l.next;
                p.next = p.next.next;
            }
        }
        l.next = null;
        p.next = tail.next;
        return root.next;
    }

    public static void main(String[] args) {
        Lc86PartitionList lc86 = new Lc86PartitionList();
        ListNode.print(lc86.partition(ListNode.build(Arrays.asList(1, 4, 3, 2, 5, 2)), 3));
        ListNode.print(lc86.partition(ListNode.build(Arrays.asList(2, 1)), 2));
    }
}
