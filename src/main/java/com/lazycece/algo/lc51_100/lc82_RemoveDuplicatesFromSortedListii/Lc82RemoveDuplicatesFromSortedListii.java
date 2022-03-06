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

package com.lazycece.algo.lc51_100.lc82_RemoveDuplicatesFromSortedListii;

import com.lazycece.model.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 先找到重复数字,再删除;空间复杂度O(n),时间复杂度O(n)
 *
 * @author lazycece
 * @date 2022/2/26
 */
public class Lc82RemoveDuplicatesFromSortedListii {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        Set<Integer> set = new HashSet<>();
        int num = head.val;
        while (node != null) {
            if (node.val == num) {
                set.add(node.val);
            } else {
                num = node.val;
            }
            node = node.next;
        }
        ListNode root = new ListNode(0);
        ListNode p = head, pre = root;
        while (p != null) {
            if (!set.contains(p.val)) {
                pre.next = p;
                pre = pre.next;
            }
            p = p.next;
        }
        pre.next = null;
        return root.next;
    }

    public static void main(String[] args) {
        Lc82RemoveDuplicatesFromSortedListii lc82 = new Lc82RemoveDuplicatesFromSortedListii();
        ListNode.print(lc82.deleteDuplicates(ListNode.build(Arrays.asList(1, 2, 3, 3, 4, 4, 5))));
        ListNode.print(lc82.deleteDuplicates(ListNode.build(Arrays.asList(1, 1, 1, 2, 3))));
        ListNode.print(lc82.deleteDuplicates(ListNode.build(Arrays.asList(1, 2, 3, 3, 4, 4))));
        ListNode.print(lc82.deleteDuplicates(ListNode.build(Arrays.asList(1, 1, 2, 2))));
    }
}
