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
 * 迭代
 *
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc701InsertIntoBST2 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode p = root;
        while (true) {
            if (val > p.val) {
                if (p.right == null) {
                    p.right = new TreeNode(val);
                    break;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new TreeNode(val);
                    break;
                }
                p = p.left;
            }
        }
        return root;
    }
}
