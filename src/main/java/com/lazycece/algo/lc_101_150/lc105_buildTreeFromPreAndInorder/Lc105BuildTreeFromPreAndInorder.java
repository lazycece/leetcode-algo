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

package com.lazycece.algo.lc_101_150.lc105_buildTreeFromPreAndInorder;

import com.lazycece.model.TreeNode;

/**
 * 递归思路
 *
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc105BuildTreeFromPreAndInorder {

    private int i = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        if (preorder.length != inorder.length) return null;
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int l, int r) {
        TreeNode t = new TreeNode(preorder[i]);
        int index = 0;
        for (; index < inorder.length; index++) {
            if (inorder[index] == preorder[i]) break;
        }
        i++;
        if (index > l) t.left = buildTree(preorder, inorder, l, index - 1);
        if (index < r) t.right = buildTree(preorder, inorder, index + 1, r);
        return t;
    }

    public static void main(String[] args) {
        Lc105BuildTreeFromPreAndInorder lc = new Lc105BuildTreeFromPreAndInorder();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode t = lc.buildTree(preorder, inorder);
        System.out.println();
    }


}
