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
 * @author lazycece
 * @date 2022/7/3
 */
public class Lc257BinaryTreePaths2 {

    private Stack<String> data = new Stack<>();

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        binaryTreePaths(root, result);
        return result;
    }

    private void binaryTreePaths(TreeNode t, List<String> result) {
        data.add(String.valueOf(t.val));
        if (t.left == null && t.right == null) {
            result.add(String.join("->", data));
        }
        if (t.left != null) binaryTreePaths(t.left, result);
        if (t.right != null) binaryTreePaths(t.right, result);
        data.pop();
    }


    public static void main(String[] args) {
        Lc257BinaryTreePaths2 lc = new Lc257BinaryTreePaths2();
        Integer[] tree = {1, 2, 3, null, 5};
//        Integer[] tree = {1};
        System.out.println(lc.binaryTreePaths(TreeNode.buildFromLevelOrder(tree)));
    }
}
