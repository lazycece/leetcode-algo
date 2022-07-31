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

package com.lazycece.algo.lc_1151_1200.lc1161_maxLevelSum;

import com.lazycece.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/7/31
 */
public class Lc1161MaxLevelSum {

    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;
        int res = Integer.MAX_VALUE, level=0;
        int max =Integer.MIN_VALUE;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while(!list.isEmpty()){
            level++;
            int sum = 0;
            List<TreeNode> le = new ArrayList<>();
            for(TreeNode t:list){
                sum+=t.val;
                if(t.left!=null) le.add(t.left);
                if(t.right!=null) le.add(t.right);
            }
            if(sum==max){
                res = Math.min(res,level);
            }else if(sum>max){
                res = level;
                max = sum;
            }
            list.clear();
            list.addAll(le);
        }
        return res;
    }
}
