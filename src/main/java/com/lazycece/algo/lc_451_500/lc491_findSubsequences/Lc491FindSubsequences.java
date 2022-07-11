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

package com.lazycece.algo.lc_451_500.lc491_findSubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lazycece
 * @date 2022/7/11
 */
public class Lc491FindSubsequences {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private Set<String> set = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length<=1) return res;
        dfs(nums,0);
        return res;
    }

    private void dfs(int[] nums, int index){
        if(list.size()>=2){
            String str="";
            for(Integer in :list){
                str= str + in+"_";
            }
            if(!set.contains(str)){
                res.add(new ArrayList<>(list));
                set.add(str);
            }
        }
        if(index == nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(!list.isEmpty()&& list.get(list.size()-1)>nums[i])
                continue;
            list.add(nums[i]);
            dfs(nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
