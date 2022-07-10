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

package com.lazycece.algo.lc_51_100.lc90_subsetsWithDup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/7/10
 */
public class Lc90SubsetsWithDup {


    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 可能存在相同元素，说明需要去重
        // 子集问题，集合内的元素顺序无关性，所以需要先排序来达到可去重效果
        Arrays.sort(nums);
        for(int i=0;i<=nums.length;i++){
            helper(nums,0,i);
        }
        return res;
    }

    private void helper(int[] nums, int index, int k){
        if(k==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<nums.length-k+1;i++){
            if(i>index&&nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            helper(nums,i+1,k-1);
            list.remove(list.size()-1);
        }
    }

}
