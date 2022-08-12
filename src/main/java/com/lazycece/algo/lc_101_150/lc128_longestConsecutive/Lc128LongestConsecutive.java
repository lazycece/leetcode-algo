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

import java.util.Arrays;

/**
 * 排序+贪心
 * @author lazycece
 * @date 2022/8/12
 */
public class Lc128LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int res=0,len=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i-1]+1==nums[i]){
                len++;
            }else if(nums[i-1]==nums[i]){
                continue;
            }
            else{
                res = Math.max(res,len);
                len=1;
            }
        }
        res = Math.max(res,len);
        return res;
    }
}
