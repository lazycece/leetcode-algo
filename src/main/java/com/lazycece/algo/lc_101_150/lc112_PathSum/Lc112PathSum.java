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

package com.lazycece.algo.lc_101_150.lc112_PathSum;

import com.lazycece.model.TreeNode;

import java.util.Stack;

/**
 * @author lazycece
 * @date 2022/7/3
 */
public class Lc112PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int num = 0;
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t != null) {
                num += t.val;
                if (t.left == null && t.right == null && num == targetSum) {
                    return true;
                }
                stack.add(t);
                stack.add(null);
                if (t.left != null) stack.add(t.left);
                if (t.right != null) stack.add(t.right);
            } else {
                t = stack.pop();
                num -= t.val;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Lc112PathSum lc = new Lc112PathSum();
//        Integer[] tree = {1, 2, 3};
//        int targetNum = 5;
        Integer[] tree = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1};
        int targetNum = 22;
        System.out.println(lc.hasPathSum(TreeNode.buildFromLevelOrder(tree), targetNum));
    }
}
