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

package com.lazycece.algo.lc_101_150.lc111_minDepth;

import com.lazycece.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 迭代思路
 *
 * @author lazycece
 * @date 2022/7/2
 */
public class Lc111MinDepth2 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int dp = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            dp++;
            Deque<TreeNode> de = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                TreeNode t = deque.pop();
                if (t.left == null && t.right == null) {
                    return dp;
                }
                if (t.left != null) de.add(t.left);
                if (t.right != null) de.add(t.right);
            }
            deque.addAll(de);
        }
        return dp;
    }

    public static void main(String[] args) {
//        Integer[] tree = {3, 9, 20, null, null, 15, 7};
        Integer[] tree = {2, null, 3, null, null, null, 4};
        Lc111MinDepth2 lc = new Lc111MinDepth2();
        System.out.println(lc.minDepth(TreeNode.buildFromLevelOrder(tree)));
    }
}
