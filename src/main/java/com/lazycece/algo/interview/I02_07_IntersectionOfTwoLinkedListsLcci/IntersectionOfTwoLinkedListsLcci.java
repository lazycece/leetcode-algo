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

package com.lazycece.algo.interview.I02_07_IntersectionOfTwoLinkedListsLcci;

import com.lazycece.model.ListNode;

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/5/4
 */
public class IntersectionOfTwoLinkedListsLcci {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        int lena = 0;
        int lenb = 0;
        while (p != null) {
            lena++;
            p = p.next;
        }
        p = headB;
        while (p != null) {
            lenb++;
            p = p.next;
        }

        int gap = 0;
        ListNode p1;
        if (lena > lenb) {
            p = headA;
            p1 = headB;
            gap = lena - lenb;
        } else if (lena < lenb) {
            p1 = headA;
            p = headB;
            gap = lenb - lena;
        } else {
            p1 = headA;
            p = headB;
        }
        while (gap-- > 0) {
            p = p.next;
        }
        while (p != null) {
            if (p == p1) {
                return p;
            }
            p = p.next;
            p1 = p1.next;
        }
        return null;
    }

    public static void main(String[] args) {

        IntersectionOfTwoLinkedListsLcci inter = new IntersectionOfTwoLinkedListsLcci();
        ListNode.print(inter.getIntersectionNode(
                ListNode.build(Arrays.asList(4, 1, 8, 4, 5)),
                ListNode.build(Arrays.asList(5, 0, 1, 8, 4, 5))));
    }
}
