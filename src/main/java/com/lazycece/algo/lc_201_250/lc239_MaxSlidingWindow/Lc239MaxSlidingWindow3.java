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

package com.lazycece.algo.lc_201_250.lc239_MaxSlidingWindow;

import com.lazycece.utils.ArrayUtils;

import java.util.PriorityQueue;

/**
 * @author lazycece
 * @date 2022/6/25
 */
public class Lc239MaxSlidingWindow3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = k>nums.length?1:nums.length-k+1;
        int[] res = new int[len];
        if(k<1) return res;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)->o2-o1);
        for(int i=0;i<k&&i<nums.length;i++){
            queue.add(nums[i]);
        }
        res[0] = queue.peek();
        int j = 1;
        for(int i=k;i<nums.length;i++){
            queue.remove(nums[i-k]);
            queue.add(nums[i]);
            res[j++]=queue.peek();
        }
        return res;
    }
    public static void main(String[] args) {
        Lc239MaxSlidingWindow3 lc = new Lc239MaxSlidingWindow3();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        ArrayUtils.print(lc.maxSlidingWindow(nums, 3));
    }
}
