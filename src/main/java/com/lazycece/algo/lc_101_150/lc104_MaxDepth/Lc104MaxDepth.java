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

package com.lazycece.algo.lc_101_150.lc104_MaxDepth;

import com.lazycece.model.TreeNode;

/**
 * @author lazycece
 * @date 2022/7/2
 */
public class Lc104MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left != null && root.right == null) return 1 + maxDepth(root.left);
        if (root.right != null && root.left == null) return 1 + maxDepth(root.right);
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    public static void main(String[] args) {
        Integer[] tree = {3, 9, 20, null, null, 15, 7};
//        Integer[] tree = {2, null, 3, null, null, null, 4};
        Lc104MaxDepth lc = new Lc104MaxDepth();
        System.out.println(lc.maxDepth(TreeNode.buildFromLevelOrder(tree)));
    }
}
