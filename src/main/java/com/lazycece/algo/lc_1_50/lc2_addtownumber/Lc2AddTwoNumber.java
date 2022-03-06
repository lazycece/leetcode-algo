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

package com.lazycece.algo.lc_1_50.lc2_addtownumber;

import com.lazycece.model.ListNode;

/**
 * @author lazycece
 * @date 2022/2/16
 */
public class Lc2AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int weigth = 0;

        ListNode root = new ListNode(0);
        ListNode next = root;

        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + weigth;
            weigth = 0;
            if (num >= 10) {
                num = num - 10;
                weigth = 1;
            }
            next.next = new ListNode(num);
            next = next.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode node = l1 != null ? l1 : l2;
        while (node != null) {
            int num = node.val + weigth;

            weigth = 0;
            if (num >= 10) {
                weigth = 1;
                num = num - 10;
            }
            next.next = new ListNode(num);
            next = next.next;
            node = node.next;
        }
        if (weigth > 0) {
            next.next = new ListNode(weigth);
            next = next.next;
        }
        return root.next;
    }
}
