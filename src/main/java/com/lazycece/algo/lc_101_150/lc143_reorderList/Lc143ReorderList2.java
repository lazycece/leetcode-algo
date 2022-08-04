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

package com.lazycece.algo.lc_101_150.lc143_reorderList;

import com.lazycece.model.ListNode;

import java.util.Stack;

/**
 * O(1)空间大小
 *
 * @author lazycece
 * @date 2022/8/4
 */
public class Lc143ReorderList2 {

    /**
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     * <p>
     * L0 → L1 → … → Ln - 1 → Ln
     * 请将其重新排列后变为：
     * <p>
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */
    public void reorderList(ListNode head) {
        if (head == null) return;
        // 寻找链表切分点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 链表切分
        ListNode p = slow.next;
        slow.next = null;
        // 切分完后反转二段链表
        ListNode pre = null;
        while (p != null) {
            ListNode t = p.next;
            p.next = pre;
            pre = p;
            p = t;
        }
        // 两个链表进行交叉关联
        ListNode l = head, r = pre;
        // 前置节点
        ListNode ll = new ListNode(0);
        while (l != null && r != null) {
            ll.next = l;
            ListNode t = l.next;
            l.next = r;
            r = r.next;
            ll = l.next;
            l = t;
        }
        ll.next = l;
    }
}
