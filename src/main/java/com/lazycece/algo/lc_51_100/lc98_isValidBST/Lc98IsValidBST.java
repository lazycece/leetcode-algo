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
public class Lc98IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t != null) {
                if (t.right != null) stack.add(t.right);
                stack.add(t);
                stack.add(null);
                if (t.left != null) stack.add(t.left);
            } else {
                t = stack.pop();
                inorder.add(t.val);
            }
        }
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i - 1) >= inorder.get(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Lc98IsValidBST lc = new Lc98IsValidBST();
//        Integer[] tree = {5, 1, 4, null, null, 3, 6};
        Integer[] tree = {2, 1, 3};
        System.out.println(lc.isValidBST(TreeNode.buildFromLevelOrder(tree)));
    }

}