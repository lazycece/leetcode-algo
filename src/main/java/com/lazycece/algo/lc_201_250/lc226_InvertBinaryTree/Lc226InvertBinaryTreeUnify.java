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

package com.lazycece.algo.lc_201_250.lc226_InvertBinaryTree;

import com.lazycece.model.TreeNode;

import java.util.Stack;

/**
 * @author lazycece
 * @date 2022/7/1
 */
public class Lc226InvertBinaryTreeUnify {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t != null) {
                if (t.left != null) stack.add(t.left);
                if (t.right != null) stack.add(t.right);
                stack.add(t);
                stack.add(null);
            } else {
                t = stack.pop();
                TreeNode tmp = t.left;
                t.left = t.right;
                t.right = tmp;
            }
        }
        return root;
    }
}
