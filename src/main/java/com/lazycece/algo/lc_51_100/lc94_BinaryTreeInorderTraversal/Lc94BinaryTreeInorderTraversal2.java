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

package com.lazycece.algo.lc_51_100.lc94_BinaryTreeInorderTraversal;

import com.lazycece.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代代替递归
 *
 * @author lazycece
 * @date 2022/6/30
 */
public class Lc94BinaryTreeInorderTraversal2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.peek();
            if (t.left != null) {
                stack.add(t.left);
                // 需要回溯的节点进行着色
                t.left = null;
            } else {
                stack.pop();
                list.add(t.val);
                if (t.right != null) {
                    stack.add(t.right);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Lc94BinaryTreeInorderTraversal2 lc = new Lc94BinaryTreeInorderTraversal2();
//        Integer[] arr = {1, null, 2, null, null, 3, null};
        Integer[] arr = {1, 2, 3, 4, 5, null, 6};
        TreeNode root = TreeNode.buildFromLevelOrder(arr);
        System.out.println(lc.inorderTraversal(root));

    }
}
