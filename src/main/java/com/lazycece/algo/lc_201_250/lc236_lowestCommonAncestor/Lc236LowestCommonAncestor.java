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

package com.lazycece.algo.lc_201_250.lc236_lowestCommonAncestor;

import com.lazycece.model.TreeNode;

/**
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc236LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 前提条件：p 和 q 均存在于给定的二叉树中
        // - 如果只在单边找到了一个节点，那么另一个节点一定为该节点的子节点
        // - 否则一定会左右子树均找到
        if (root == null || root == q || root == p) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null && r == null) return null;
        if (l == null) return r;
        if (r == null) return l;
        return root;
    }
}
