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

package com.lazycece.algo.lc_101_150.lc111_minDepth;

import com.lazycece.model.TreeNode;

/**
 * @author lazycece
 * @date 2022/7/2
 */
public class Lc111MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root);
    }

    private int helper(TreeNode t) {
        if (t.left == null && t.right == null) return 1;
        if (t.left != null && t.right == null) return 1 + helper(t.left);
        if (t.right != null && t.left == null) return 1 + helper(t.right);
        return 1 + Math.min(helper(t.left), helper(t.right));
    }

    public static void main(String[] args) {
//        Integer[] tree = {3, 9, 20, null, null, 15, 7};
        Integer[] tree = {2,null,3,null,null,null,4};
        Lc111MinDepth lc = new Lc111MinDepth();
        System.out.println(lc.minDepth(TreeNode.buildFromLevelOrder(tree)));
    }
}
