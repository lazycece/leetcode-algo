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
public class Lc145PostorderTraversal2 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.peek();
            if (t.left != null) {
                TreeNode tmp = t.left;
                t.left = null;
                stack.add(tmp);
            } else if (t.right != null) {
                TreeNode tmp = t.right;
                t.right = null;
                stack.add(tmp);
            } else {
                list.add(t.val);
                stack.pop();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Lc145PostorderTraversal2 lc = new Lc145PostorderTraversal2();

        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, null};
        TreeNode root = TreeNode.buildFromLevelOrder(arr);

        System.out.println(lc.postorderTraversal(root));
    }
}
