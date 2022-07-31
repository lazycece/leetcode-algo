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

package com.lazycece.algo.lc_101_150.lc146_LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义双向链表
 *
 * @author lazycece
 * @date 2022/7/28
 */
public class Lc146LRUCache2 {

    public Map<Integer, Integer> map = new HashMap<>();
    private int len = 0;
    private int capacity = 0;
    private DLNode head, tail;

    public Lc146LRUCache2(int capacity) {
        this.capacity = capacity;
        head = new DLNode(-1);
        tail = new DLNode(-2);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Integer val = map.getOrDefault(key, -1);
        if (val != -1) {
            least(key);
        }
        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            least(key);
        } else {
            map.put(key, value);
            DLNode node = new DLNode(key,head,head.next);
            node.next.pre = node;
            head.next = node;
            if (len < capacity) {
                len++;
            } else {
                map.remove(tail.pre.val);
                tail.pre=tail.pre.pre;
                tail.pre.next = tail;
            }
        }
    }

    private void least(int val) {
        DLNode p = head.next;
        while (p!=null&&p.val != val) {
            p = p.next;
        }
        p.pre.next = p.next;
        p.next.pre = p.pre;
        p.next = head.next;
        p.pre = head;
        head.next = p;
        p.next.pre = p;
    }

    public static class DLNode {
        DLNode pre;
        DLNode next;
        int val;

        public DLNode(int val) {
            this.val = val;
        }

        public DLNode(int val, DLNode pre, DLNode next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Lc146LRUCache2 lRUCache = new Lc146LRUCache2(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }

}
