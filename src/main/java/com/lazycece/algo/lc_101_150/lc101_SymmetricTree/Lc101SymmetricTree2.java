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

package com.lazycece.algo.lc_101_150.lc101_SymmetricTree;

import com.lazycece.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 迭代法
 *
 * @author lazycece
 * @date 2022/7/3
 */
public class Lc101SymmetricTree2 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root.left);
        deque.add(root.right);
        while (deque.size() >= 2) {
            TreeNode l = deque.pop(), r = deque.pop();
            if (l == null && r == null) continue;
            if (l == null || r == null) return false;
            if (l.val != r.val) return false;
            deque.add(l.left);
            deque.add(r.right);
            deque.add(l.right);
            deque.add(r.left);
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        Lc101SymmetricTree2 lc = new Lc101SymmetricTree2();
        Integer[] tree = {1, 2, 2, 3, 4, 4, 3};
//        Integer[] tree = {1,2,2,null,3,null,3};
        System.out.println(lc.isSymmetric(TreeNode.buildFromLevelOrder(tree)));
    }
}
