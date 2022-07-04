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

package com.lazycece.algo.lc_501_550.lc530_MinimumDifference;

import com.lazycece.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序为升序数组思路
 *
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc530MinimumDifference2 {

    public int getMinimumDifference(TreeNode root) {
        if (root == null) throw new IllegalArgumentException("param error");
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t != null) {
                if (t.right != null) stack.add(t.right);
                stack.add(t);
                stack.add(null);
                if (t.left != null) stack.add(t.left);
            } else {
                t = stack.pop();
                list.add(t.val);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, Math.abs(list.get(i - 1) - list.get(i)));
        }
        return min;
    }

    public static void main(String[] args) {
        Lc530MinimumDifference2 lc = new Lc530MinimumDifference2();
        Integer[] tree = {1, 0, 48, null, null, 12, 49};
        System.out.println(lc.getMinimumDifference(TreeNode.buildFromLevelOrder(tree)));
    }
}
