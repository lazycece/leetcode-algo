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

package com.lazycece.algo.lc_501_550.lc513_findBottomLeftValue;

import com.lazycece.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 层序遍历
 *
 * @author lazycece
 * @date 2022/7/3
 */
public class Lc513FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) throw new IllegalArgumentException("param error");
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int result = root.val;
        while (!deque.isEmpty()) {
            Deque<TreeNode> de = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                TreeNode t = deque.pop();
                if (t.left != null) de.add(t.left);
                if (t.right != null) de.add(t.right);
            }
            if (!de.isEmpty()) result = de.peek().val;
            deque.addAll(de);
        }
        return result;
    }
}
