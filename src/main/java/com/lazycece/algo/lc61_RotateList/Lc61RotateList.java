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

package com.lazycece.algo.lc61_RotateList;

import com.lazycece.model.ListNode;

import java.util.Arrays;

/**
 * 根据链表长度求余,判断移动次数
 *
 * @author lazycece
 * @date 2022/2/25
 */
public class Lc61RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        k = k % len;
        if (k == 0) return head;
        ListNode root = new ListNode(0);
        root.next = head;
        node = head;
        ListNode pre = root;
        int i = 0;
        while (i < len - k) {
            i++;
            pre = node;
            node = node.next;
        }
        pre.next = null;
        ListNode r = node;
        while (r.next != null) {
            r = r.next;
        }
        r.next = root.next;
        return node;
    }

    public static void main(String[] args) {
        Lc61RotateList lc61 = new Lc61RotateList();
        ListNode.print(lc61.rotateRight(
                ListNode.build(Arrays.asList(1, 2, 3, 4, 5)),
                2));
        ListNode.print(lc61.rotateRight(
                ListNode.build(Arrays.asList(0, 1, 2)),
                4));
        ListNode.print(lc61.rotateRight(
                ListNode.build(Arrays.asList(1, 2, 3)),
                3));
    }
}
