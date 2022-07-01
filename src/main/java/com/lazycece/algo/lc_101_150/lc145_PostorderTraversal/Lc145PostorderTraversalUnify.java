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

package com.lazycece.algo.lc_101_150.lc145_PostorderTraversal;

import com.lazycece.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lazycece
 * @date 2022/6/29
 */
public class Lc145PostorderTraversalUnify {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t != null) {
                stack.add(t);
                stack.add(null);
                if (t.right != null) stack.add(t.right);
                if (t.left != null) stack.add(t.left);
            } else {
                t = stack.pop();
                list.add(t.val);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Lc145PostorderTraversalUnify lc = new Lc145PostorderTraversalUnify();

        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, null};
        TreeNode root = TreeNode.buildFromLevelOrder(arr);

        System.out.println(lc.postorderTraversal(root));
    }
}
