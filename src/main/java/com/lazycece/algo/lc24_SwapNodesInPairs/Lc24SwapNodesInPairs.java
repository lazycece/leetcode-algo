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

package com.lazycece.algo.lc24_SwapNodesInPairs;

import com.lazycece.model.ListNode;

import java.util.Arrays;

/**
 * 双指针移动
 *
 * @author lazycece
 * @date 2022/2/22
 */
public class Lc24SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode l = root;
        ListNode r = root.next;
        while (r != null && r.next != null) {
            l.next = r.next;
            r.next = r.next.next;
            l.next.next = r;
            l = r;
            r = r.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        Lc24SwapNodesInPairs lc23 = new Lc24SwapNodesInPairs();
        ListNode.print(lc23.swapPairs(ListNode.build(Arrays.asList(1, 2, 3, 4))));
        ListNode.print(lc23.swapPairs(null));
        ListNode.print(lc23.swapPairs(ListNode.build(Arrays.asList(1))));

    }
}
