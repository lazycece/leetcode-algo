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
public class Lc669TrimBST2 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            root = root.right;
            return trimBST(root, low, high);
        } else if (root.val > high) {
            root = root.left;
            return trimBST(root, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }


    public static void main(String[] args) {
        Lc669TrimBST2 lc = new Lc669TrimBST2();
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
