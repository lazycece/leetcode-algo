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

package com.lazycece.model;

import java.util.List;

/**
 * @author lazycece
 * @date 2022/2/16
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode build(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        ListNode l = new ListNode(0);
        ListNode r = l;
        for (Integer i : list) {
            r.next = new ListNode(i);
            r = r.next;
        }
        return l.next;
    }

    public static void print(ListNode l) {
        while (l != null) {
            System.out.print(l.val + ",");
            l = l.next;
        }
    }
}
