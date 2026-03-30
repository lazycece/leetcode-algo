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

package com.lazycece.algo.lc_201_250.lc230_kthSmallestElementInABst;

import com.lazycece.model.TreeNode;

import java.util.Stack;

/**
 * @author lazycece
 * @date 2026/3/30
 */
public class Lc230KthSmallestElementInABst {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        // 所有的left节点压栈
        while (p != null) {
            stack.add(p);
            p = p.left;
        }

        int i = 0;
        while (!stack.isEmpty()) {
            // 出栈计算最小数量
            TreeNode node = stack.pop();
            // System.out.print(node.val +" ,");
            i++;
            if (i == k)
                return node.val;

            // 如果有右节点，继续压栈--保持二叉搜索树的特性 left<node<right
            if (node.right != null) {
                node = node.right;
                stack.add(node);
                while (node.left != null) {
                    node = node.left;
                    stack.add(node);
                }
            }

            // System.out.println("==================");
        }
        throw new RuntimeException("error params");
    }
}
