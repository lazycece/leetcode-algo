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

package com.lazycece.algo.lc_51_100.lc98_isValidBST;

import com.lazycece.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历，为升序
 *
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc98IsValidBST2 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer up, Integer low) {

        // 递归，up为后继节点值，low为前驱节点值
        if (root == null) return true;
        if (up != null && root.val >= up) return false;
        if (low != null && root.val <= low) return false;
        return isValidBST(root.left, root.val, low)
                && isValidBST(root.right, up, root.val);
    }

    public static void main(String[] args) {
        Lc98IsValidBST2 lc = new Lc98IsValidBST2();
//        Integer[] tree = {5, 1, 4, null, null, 3, 6};
        Integer[] tree = {2, 1, 3};
        System.out.println(lc.isValidBST(TreeNode.buildFromLevelOrder(tree)));
    }

}