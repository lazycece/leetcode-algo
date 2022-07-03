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

package com.lazycece.algo.lc_251_300.lc257_BinaryTreePaths;

import com.lazycece.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代法
 *
 * @author lazycece
 * @date 2022/7/3
 */
public class Lc257BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        Stack<String> data = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t != null) {
                data.add(String.valueOf(t.val));
                if (t.left == null && t.right == null) {
                    result.add(String.join("->", data));
                    data.pop();
                    continue;
                }
                stack.add(t);
                stack.add(null);
                if (t.right != null) stack.add(t.right);
                if (t.left != null) stack.add(t.left);
            } else {
                stack.pop();
                data.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Lc257BinaryTreePaths lc = new Lc257BinaryTreePaths();
//        Integer[] tree = {1, 2, 3, null, 5};
        Integer[] tree = {1};
        System.out.println(lc.binaryTreePaths(TreeNode.buildFromLevelOrder(tree)));
    }
}
