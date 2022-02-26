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

package com.lazycece.algo.lc83_RemoveDuplicatesFromSortedList;

import com.lazycece.algo.lc82_RemoveDuplicatesFromSortedListii.Lc82RemoveDuplicatesFromSortedListii3;
import com.lazycece.model.ListNode;

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/2/27
 */
public class Lc83RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        int num = head.val;
        while (p.next != null) {
            if (p.next.val == num) {
                p.next = p.next.next;
            } else {
                p = p.next;
                num = p.val;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Lc83RemoveDuplicatesFromSortedList lc83 = new Lc83RemoveDuplicatesFromSortedList();
        ListNode.print(lc83.deleteDuplicates(ListNode.build(Arrays.asList(1, 2, 3, 3, 4, 4, 5))));
        ListNode.print(lc83.deleteDuplicates(ListNode.build(Arrays.asList(1, 1, 1, 2, 3))));
        ListNode.print(lc83.deleteDuplicates(ListNode.build(Arrays.asList(1, 2, 3, 3, 4, 4))));
        ListNode.print(lc83.deleteDuplicates(ListNode.build(Arrays.asList(1, 1, 2, 2))));
    }
}
