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

package com.lazycece.algo.lc_201_250.lc215_findKthLargest;

import java.util.Random;

/**
 * @author lazycece
 * @date 2022/8/9
 */
public class Lc215FindKthLargest {

    private Random rd = new Random();

    public int findKthLargest(int[] nums, int k) {
        helper(nums, 0, nums.length - 1, k - 1);
        return nums[k - 1];
    }

    private void helper(int[] nums, int l, int r, int index) {
        // [3,2, 1 ,5,6,4], nums[rdm]=1
        if (l > r) return;
        int rdm = random(l, r);
        int temp = nums[rdm];
        nums[rdm] = nums[l];
        int ll = l, rr = r;
        while (ll < rr) {
            while (ll < rr && nums[rr] <= temp) {
                rr--;
            }
            nums[ll]=nums[rr];
            while (ll < rr&& nums[ll]>=temp) {
                ll++;
            }
            nums[rr]=nums[ll];
        }
        nums[ll]=temp;
        if (ll == index) {

        } else if (ll < index) {
            helper(nums, ll+1, r, index);
        } else {
            helper(nums, l, rr-1, index);
        }
    }

    private int random(int l, int r) {
        return rd.nextInt(r - l + 1) + l;
    }


    public static void main(String[] args) {
        Lc215FindKthLargest lc = new Lc215FindKthLargest();
        int[] num = {3, 2, 1, 5, 6, 4};
        System.out.println(lc.findKthLargest(num, 2));
//        int[] num1 = {3, 2, 1, 5, 6, 4};
//        System.out.println(lc.findKthLargest(num1, 3));
    }
}
