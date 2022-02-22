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

package com.lazycece.algo.lc19_RemoveNthNodeFromEndOfList;

import com.lazycece.model.ListNode;

import java.util.Arrays;

/**
 * 转换为正向的第 x 个节点
 *
 * @author lazycece
 * @date 2022/2/22
 */
public class Lc19RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        int k = len - n + 1;
        if (k <= 0) throw new IllegalArgumentException("parameter n error");
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode l = start;
        ListNode r = start.next;
        int i = 1;
        while (i < k) {
            i++;
            l = l.next;
            r = r.next;
        }
        l.next = r.next;
        return start.next;
    }

    public static void main(String[] args) {
//        ListNode l = ListNode.build(Arrays.asList(1, 2, 3, 4, 5));
        ListNode l = ListNode.build(Arrays.asList(1));

        Lc19RemoveNthNodeFromEndOfList lc19 = new Lc19RemoveNthNodeFromEndOfList();
        ListNode node = lc19.removeNthFromEnd(l, 1);
        ListNode.print(node);
    }
}
