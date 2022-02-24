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

package com.lazycece.algo.lc25_ReverseNodesInKGroup;

import com.lazycece.model.ListNode;

import java.util.Arrays;

/**
 * 非递归 + 3指针
 *
 * @author lazycece
 * @date 2022/2/24
 */
public class Lc25ReverseNodesInKGroup2 {

    public ListNode reverseKGroup(ListNode head, int k) {
            ListNode p = new ListNode(0);
            p.next = head;
            ListNode r = head;
            ListNode root = p;
            while (canReverse(head, k)) {
                ListNode l = null;
                int len = 0;
                while (len < k) {
                    len++;
                    ListNode t = r.next;
                    r.next = l;
                    l = r;
                    r = t;
                }
                p.next = l;
                p = head;
                head.next = r;
                head = r;
            }
            return root.next;
    }

//        输入：head = [1,2,3,4,5,6,7], k = 3
//        输出：[3,2,1,6,5,4,7]

    private boolean canReverse(ListNode head, int k) {
        ListNode node = head;
        int i = 0;
        while (node != null && i < k) {
            i++;
            node = node.next;
        }
        return i == k;
    }

    public static void main(String[] args) {
        Lc25ReverseNodesInKGroup2 lc25 = new Lc25ReverseNodesInKGroup2();
        ListNode.print(
                lc25.reverseKGroup(
                        ListNode.build(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), 3));
    }
}
