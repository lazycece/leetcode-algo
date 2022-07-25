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

package com.lazycece.algo.lc_451_500.lc480_medianSlidingWindow;


import java.util.PriorityQueue;

/**
 * @author lazycece
 * @date 2022/7/23
 */
public class Lc480MedianSlidingWindow2 {

    // small.len==large.len or small.len = large.len + 1;
    private PriorityQueue<Integer> small = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
    // 比较符不能用o2-o1，会超出int范围
    private PriorityQueue<Integer> large = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int len = n - k + 1;
        double[] res = new double[len];
        int i = 0;
        for (; i < k; i++) {
            small.add(nums[i]);
        }
        i = 0;
        while (i++ < k / 2) {
            large.add(small.remove());
        }
        if (k % 2 == 0) {
            res[0] = ((double) small.peek() + (double) large.peek()) / 2;
        } else {
            res[0] = small.peek();
        }

        for (i = k; i < n; i++) {
            int l = nums[i - k];
            // 移除窗口左边元素
            if (small.contains(l)) {
                small.remove(l);
            } else {
                large.remove(l);
            }
            int r = nums[i];

            // 添加元素
            if (!small.isEmpty() && r > small.peek()) {
                small.add(r);
            } else if (!large.isEmpty() && r < large.peek()) {
                large.add(r);
            } else {
                small.add(r);
            }
            // 调整集合
            while (large.size() >= small.size()) {
                small.add(large.remove());
            }
            int gap = small.size() - large.size();
            int j = 0;
            while (j++ < gap / 2) {
                large.add(small.remove());
            }

            // 计算中位数
            if (k % 2 == 0) {
                res[i - k + 1] = ((double) small.peek() + (double) large.peek()) / 2;
            } else {
                res[i - k + 1] = small.peek();
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int[] nums = {1,2,3,4,2,3,1,4,2};
        int[] nums = {-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648};
        Lc480MedianSlidingWindow2 lc = new Lc480MedianSlidingWindow2();
        double[] res = lc.medianSlidingWindow(nums, 3);
        System.out.println();

        PriorityQueue<Integer> de = new PriorityQueue<>();
        for (int i : nums) {
            de.add(i);
        }
        while (!de.isEmpty()) {
            System.out.println(de.remove());
        }
    }
}
