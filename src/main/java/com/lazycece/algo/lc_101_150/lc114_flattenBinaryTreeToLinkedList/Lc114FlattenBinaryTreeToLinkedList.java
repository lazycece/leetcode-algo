/*
 *    Copyright 2026 lazycece<lazycece@gmail.com>
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

package com.lazycece.algo.lc_101_150.lc114_flattenBinaryTreeToLinkedList;

import com.lazycece.model.TreeNode;

/**
 * @author lazycece
 * @date 2026/3/29
 */
public class Lc114FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        // 以前序遍历的视角，逐步把left节点并入right链
        while (curr != null) {
            // System.out.print(curr.val+",");
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode last = next;
                // 寻找前序遍历的最后一个节点
                while (last != null && last.right != null) {
                    last = last.right;
                }
                last.right = curr.right;

                curr.left = null;
                curr.right = next;
            }

            curr = curr.right;
        }
    }
}
