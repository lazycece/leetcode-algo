/*
 *    Copyright 2026 lazycece<lazycece@gmail.com>
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

package com.lazycece.algo.lc_401_450.lc437_pathSumiii;

import com.lazycece.model.TreeNode;

/**
 * @author lazycece
 * @date 2026/3/30
 */
public class Lc437PathSumiii {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int ret = 0;
        ret += helper(root, targetSum);
        // 思路拆解：每个节点都当作根节点来计算一次向下的路径
        // 通过这种方式，来避免重复计算的问题
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);

        return ret;
    }

    private int helper(TreeNode root, long targetSum) {
        if (root == null) return 0;
        int ret = 0;
        if (root.val == targetSum) ret++;

        ret += helper(root.left, targetSum - root.val);
        ret += helper(root.right, targetSum - root.val);
        return ret;
    }
}
