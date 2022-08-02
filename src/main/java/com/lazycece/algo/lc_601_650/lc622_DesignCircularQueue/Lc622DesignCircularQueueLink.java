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

package com.lazycece.algo.lc_601_650.lc622_DesignCircularQueue;

/**
 * @author lazycece
 * @date 2022/8/3
 */
public class Lc622DesignCircularQueueLink {
    public static class DLNode{
        private DLNode next;
        private DLNode pre;
        private int val;

        public DLNode(int val){
            this.val = val;
        }
    }

    private DLNode head ;
    private DLNode tail;
    private int size = 0;
    private int len = 0;

    public Lc622DesignCircularQueueLink(int k) {
        len = k;
        head = new DLNode(0);
        tail = new DLNode(0);
        head.next = tail;
        tail.next = head;
        head.pre = tail;
        tail.pre = head;
    }

    public boolean enQueue(int value) {
        if(size==len) return false;
        DLNode p = new DLNode(value);
        tail.pre.next = p;
        p.pre = tail.pre;
        p.next = tail;
        tail.pre = p;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(size==0)return false;
        head.next.next.pre = head;
        head.next = head.next.next;
        size--;
        return true;
    }

    public int Front() {
        if(size==0) return -1;
        return head.next.val;
    }

    public int Rear() {
        if(size==0) return -1;
        return tail.pre.val;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==len;
    }
}
