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

package com.lazycece.algo.lc_651_700.lc669_trimBST;

import com.lazycece.model.TreeNode;

/**
 * 先修减low，再修剪high
 *
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc669TrimBST {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode parent = new TreeNode(0, null, root);
        trimBSTLow(false, parent, parent.right, low);
        trimBSTHigh(false, parent, parent.right, high);
        return parent.right;
    }


    private void trimBSTLow(boolean l, TreeNode pre, TreeNode root, int low) {
        if (root == null) return;
        if (root.val == low) {
            root.left = null;
        } else if (root.val < low) {
            if (l) {
                pre.left = root.right;
                trimBSTLow(true, pre, root.right, low);
            } else {
                pre.right = root.right;
                trimBSTLow(false, pre, root.right, low);
            }
        } else {
            trimBSTLow(true, root, root.left, low);
        }
    }

    private void trimBSTHigh(boolean l, TreeNode pre, TreeNode root, int high) {
        if (root == null) return;
        if (root.val == high) {
            root.right = null;
        } else if (root.val > high) {
            if (l) {
                pre.left = root.left;
                trimBSTHigh(true, pre, root.left, high);
            } else {
                pre.right = root.left;
                trimBSTHigh(false, pre, root.left, high);
            }
        } else {
            trimBSTHigh(false, root, root.right, high);
        }
    }

    public static void main(String[] args) {
        Lc669TrimBST lc = new Lc669TrimBST();
//        Integer[] tree = {1, 0, 2};
//        int low = 1, high = 2;
//        Integer[] tree = {3, 0, 4, null, 2, null, null, null, null, 1};
//        int low = 1, high = 3;
        Integer[] tree = {3, 2, 4, 1};
        int low = 1, high = 1;
        TreeNode t = lc.trimBST(TreeNode.buildFromLevelOrder(tree), low, high);
        System.out.println();
    }
}
