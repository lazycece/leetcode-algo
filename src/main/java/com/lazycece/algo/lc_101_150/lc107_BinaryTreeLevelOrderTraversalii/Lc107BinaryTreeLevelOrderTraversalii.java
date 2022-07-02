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

package com.lazycece.algo.lc_101_150.lc107_BinaryTreeLevelOrderTraversalii;

import com.lazycece.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/7/2
 */
public class Lc107BinaryTreeLevelOrderTraversalii {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> re = new ArrayList<>();
        if (root == null) return re;
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> l = new ArrayList<>();
            for (TreeNode t : level) {
                list.add(t.val);
                if (t.left != null) l.add(t.left);
                if (t.right != null) l.add(t.right);
            }
            level.clear();
            level.addAll(l);
            re.add(0, list);
        }
        return re;
    }
}
