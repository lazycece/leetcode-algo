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

package com.lazycece.algo.lc_1_50.lc45_jump;

/**
 * dp降维
 *
 * @author lazycece
 * @date 2022/8/11
 */
public class Lc45JumpGreedy {

    public int jump(int[] nums) {
        int n = nums.length;
        int maxIndex=0;
        int end=0;
        int res=0;
        for(int i=0;i<n;i++){
            if(i>maxIndex) throw new RuntimeException("error param");
            maxIndex = Math.max(nums[i]+i,maxIndex);
            if(i==end){
                // 一次最大区间内只记录一次跳跃
                res++;
                end = maxIndex;
            }
            if(end>=n-1) return res;
        }
        throw new RuntimeException("error param");
    }
}
