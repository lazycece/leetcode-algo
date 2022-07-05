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

package com.lazycece.algo.lc_701_750.lc701_insertIntoBST;

import com.lazycece.model.TreeNode;

/**
 * 递归
 *
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc701InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val) {
            if (root.right == null) root.right = new TreeNode(val);
            insertIntoBST(root.right, val);
        }
        if (val < root.val) {
            if (root.left == null) root.left = new TreeNode(val);
            insertIntoBST(root.left, val);
        }
        return root;
    }
}
