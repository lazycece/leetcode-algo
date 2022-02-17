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

package com.lazycece.algo.lc2_addtownumber;

import com.lazycece.model.ListNode;

/**
 * 递归思路
 * 按顺序相加,处理10进制进位情况
 *
 * @author lazycece
 * @date 2022/2/16
 */
public class Lc2AddTwoNumber2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return merge(l1, l2, 0);
    }

    private ListNode merge(ListNode l1, ListNode l2, int add) {
        if (l1 == null && l2 == null) {
            return add > 0 ? new ListNode(add) : null;
        }
        int val1 = 0;
        int val2 = 0;
        if (l1 != null) {
            val1 = l1.val;
        }
        if (l2 != null) {
            val2 = l2.val;
        }
        int value = val1 + val2 + add;
        add = 0;
        if (value >= 10) {
            value = value - 10;
            add = 1;
        }
        ListNode l = new ListNode(value);
        l.next = merge(l1 == null ? null : l.next, l2 == null ? null : l2.next, add);
        return l;
    }
}
