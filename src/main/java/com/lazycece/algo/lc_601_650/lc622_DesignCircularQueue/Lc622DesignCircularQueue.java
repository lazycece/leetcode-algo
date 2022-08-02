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

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/8/3
 */
public class Lc622DesignCircularQueue {

    private int front = 0;
    private int rear = 0;
    private int size = 0;
    private int len = 0;
    private Integer[] arr;

    public Lc622DesignCircularQueue(int k) {
        len=k;
        arr = new Integer[len];
        Arrays.fill(arr,null);
    }

    public boolean enQueue(int value) {
        if(size==len) return false;
        if(size==0){
            arr[rear]=value;
            size++;
            return true;
        }
        rear++;
        if(rear==len) rear=0;
        arr[rear]=value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(size==0) return false;
        arr[front]=null;
        size--;
        if(size==0)  return true;
        front++;
        if(front==len) front=0;
        return true;
    }

    public int Front() {
        if(size==0) return -1;
        return arr[front];
    }

    public int Rear() {
        if(size==0) return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==len;
    }
}
