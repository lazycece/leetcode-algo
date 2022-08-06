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

package com.lazycece.algo.lc_601_650.lc623_addOneRow;

import com.lazycece.model.TreeNode;


/**
 * @author lazycece
 * @date 2022/8/5
 */
public class Lc623AddOneRow {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return helper(root, val, depth, true);
    }

    private TreeNode helper(TreeNode root, int val, int depth, boolean left) {
        if (depth == 1) {
            if (left) return new TreeNode(val, root, null);
            else return new TreeNode(val, null, root);
        }
        if (root == null) return null;
        root.left = helper(root.left, val, depth - 1, true);
        root.right = helper(root.right, val, depth - 1, false);
        return root;
    }
}
