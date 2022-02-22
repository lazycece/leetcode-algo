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

package com.lazycece.algo.lc23_MergeKSortedLists;

import com.lazycece.model.ListNode;

/**
 * 逐个合并
 *
 * @author lazycece
 * @date 2022/2/22
 */
public class Lc23MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode node = lists[0];
        for (int i = 1; i < lists.length; i++) {
            node = mergeTwoLists(node, lists[i]);
        }
        return node;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode l = list1;
        ListNode r = list2;
        ListNode root = new ListNode(0);
        ListNode node = root;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                node.next = l;
                l = l.next;
            } else {
                node.next = r;
                r = r.next;
            }
            node = node.next;
        }
        if (l != null) {
            node.next = l;
        } else {
            node.next = r;
        }
        return root.next;
    }


    public static void main(String[] args) {

    }
}
