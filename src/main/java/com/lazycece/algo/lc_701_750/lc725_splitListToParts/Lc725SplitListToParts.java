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

package com.lazycece.algo.lc_701_750.lc725_splitListToParts;

import com.lazycece.model.ListNode;

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/7/28
 */
public class Lc725SplitListToParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        int len = n / k, offset = n % k;
        ListNode[] res = new ListNode[k];
        ListNode root = new ListNode(0, head);
        p = head;
        int i = 0;
        int j = 0;
        while (p != null) {
            i++;
            if (offset == 0 && i == len) {
                ListNode t = p.next;
                p.next = null;
                res[j++] = root.next;
                root = new ListNode(0, t);
                p = t;
                i = 0;
            } else if (offset > 0 && i == len + 1) {
                ListNode t = p.next;
                p.next = null;
                res[j++] = root.next;
                root = new ListNode(0, t);
                p = t;
                offset--;
                i = 0;
            } else {
                p = p.next;
            }
        }
        for (int m = j; m < k; m++) {
            res[m] = null;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc725SplitListToParts lc = new Lc725SplitListToParts();
        ListNode[] res = lc.splitListToParts(ListNode.build(Arrays.asList(1, 2, 3)), 5);
        res = lc.splitListToParts(ListNode.build(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), 3);
        System.out.println();
    }
}
