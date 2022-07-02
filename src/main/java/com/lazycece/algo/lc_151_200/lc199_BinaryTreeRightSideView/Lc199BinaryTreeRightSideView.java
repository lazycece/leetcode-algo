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

package com.lazycece.algo.lc_151_200.lc199_BinaryTreeRightSideView;

import com.lazycece.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用层序遍历来获取最右侧的节点值
 *
 * @author lazycece
 * @date 2022/7/2
 */
public class Lc199BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<TreeNode> l = new ArrayList<>();
            List<Integer> in = new ArrayList<>();
            for (TreeNode t : level) {
                in.add(t.val);
                if (t.right != null) l.add(t.right);
                if (t.left != null) l.add(t.left);
            }
            level.clear();
            level.addAll(l);

            list.add(in.get(0));
        }
        return list;
    }
}
