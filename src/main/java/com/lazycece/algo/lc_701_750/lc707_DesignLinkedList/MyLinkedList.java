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

package com.lazycece.algo.lc_701_750.lc707_DesignLinkedList;

/**
 * 双向链表
 *
 * @author lazycece
 * @date 2022/5/4
 */
public class MyLinkedList {


    class ListNode {
        int val;
        ListNode prev, next;

        ListNode(int x) {
            val = x;
        }

        ListNode(ListNode p, ListNode n, int x) {
            prev = p;
            next = n;
            val = x;
        }
    }

    ListNode head = null;
    ListNode tail = null;
    int size = 0;

    public MyLinkedList() {
        // 虚拟头尾指针
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        ListNode p = head.next;
        int i = 0;
        while (p != null) {
            if (i == index) {
                return p.val;
            }
            p = p.next;
            i++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(head, head.next, val);
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(tail.prev, tail, val);
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index < 0) {
            addAtHead(val);
            return;
        }

        ListNode p = head.next;
        int i = 0;
        while (p != null) {
            if (i == index) {
                ListNode node = new ListNode(p.prev, p, val);
                p.prev.next = node;
                p.prev = node;
                size++;
                return;
            }
            i++;
            p = p.next;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        ListNode p = head.next;
        int i = 0;
        while (p != null) {
            if (i == index) {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                size--;
                return;
            }
            p = p.next;
            i++;
        }
    }
}
