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

package com.lazycece.algo.lc_701_750.lc704_BinarySearch;

/**
 * @author lazycece
 * @date 2022/4/24
 */
public class Lc704BinarySearch2 {

    public int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) r = mid-1;
            else  l = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Lc704BinarySearch2 lc = new Lc704BinarySearch2();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(lc.search(nums, 9));
        System.out.println(lc.search(nums, 2));
        System.out.println(lc.search(nums, 12));
        System.out.println(lc.search(nums, -1));

    }
}
