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

package com.lazycece.algo.lc_101_150.lc128_longestConsecutive;

import java.util.HashSet;
import java.util.Set;

/**
 * On时间复杂度
 * @author lazycece
 * @date 2022/8/12
 */
public class Lc128LongestConsecutiveOn {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums)set.add(i);
        int res=0;

        for(int i:set){
           if(!set.contains(i-1)){
               int len=1;
               int cur = i;
               while(set.contains(cur+1)){
                   cur = cur+1;
                   len++;
               }
               res = Math.max(len,res);
           }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        Lc128LongestConsecutiveOn lc = new Lc128LongestConsecutiveOn();
        System.out.println(lc.longestConsecutive(nums));
    }
}
