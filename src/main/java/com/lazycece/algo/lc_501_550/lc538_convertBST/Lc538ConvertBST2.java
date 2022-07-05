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

package com.lazycece.algo.lc_501_550.lc538_convertBST;

import com.lazycece.model.TreeNode;

import java.util.Stack;

/**
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc538ConvertBST2 {

    private int num = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        num += root.val;
        root.val = num;
        convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {
        Lc538ConvertBST2 lc = new Lc538ConvertBST2();
        Integer[] tree = {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        TreeNode t = lc.convertBST(TreeNode.buildFromLevelOrder(tree));
        System.out.println();
    }

}
