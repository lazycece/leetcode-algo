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

/**
 * @author lazycece
 * @date 2022/6/30
 */
public class Lc94BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

    public static void main(String[] args) {
        Lc94BinaryTreeInorderTraversal lc = new Lc94BinaryTreeInorderTraversal();
        Integer[] arr = {1, null, 2, null, null, 3, null};
        TreeNode root = TreeNode.buildFromLevelOrder(arr);
        System.out.println(lc.inorderTraversal(root));

    }
}
