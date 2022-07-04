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

package com.lazycece.algo.lc_101_150.lc106_buildTreeFromInAndPostOrder;

import com.lazycece.model.TreeNode;

/**
 * 递归思想
 *
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc106buildTreeFromInAndPostOrder {

    private int i = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || inorder.length != postorder.length)
            return null;
        i = postorder.length - 1;
        return buildTree(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int l, int r) {
        TreeNode t = new TreeNode(postorder[i]);
        int index = 0;
        for (; index < inorder.length; index++) {
            if (inorder[index] == postorder[i])
                break;
        }
        i--;
        if (index < r) t.right = buildTree(inorder, postorder, index + 1, r);
        if (index > l) t.left = buildTree(inorder, postorder, l, index - 1);
        return t;
    }


    public static void main(String[] args) {
        Lc106buildTreeFromInAndPostOrder lc = new Lc106buildTreeFromInAndPostOrder();
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode t = lc.buildTree(inorder, postorder);
        System.out.println();
    }
}
