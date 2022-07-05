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

package com.lazycece.algo.lc_401_450.lc450_deleteNode;

import com.lazycece.model.TreeNode;

/**
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc450DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        // 链表删除思想,双指针
        if (root == null) return null;
        TreeNode parent = new TreeNode(0, null, root);
        TreeNode p = root, pre = parent;
        boolean l = false;
        while (p != null) {
            if (p.val == key) {
                break;
            } else if (key > p.val) {
                pre = p;
                p = p.right;
                l = false;
            } else {
                pre = p;
                p = p.left;
                l = true;
            }
        }
        // 未找到则不删除
        if (p == null) return parent.right;
        // 升起右孩子节点，寻找右子树的前驱
        if (p.left == null) {
            if (l) pre.left = p.right;
            else pre.right = p.right;
        } else if (p.right == null) {
            if (l) pre.left = p.left;
            else pre.right = p.left;
        } else {
            TreeNode index = p.right;
            while (index.left != null) {
                index = index.left;
            }
            index.left = p.left;
            if (l) pre.left = p.right;
            else pre.right = p.right;
        }

        return parent.right;
    }
}
