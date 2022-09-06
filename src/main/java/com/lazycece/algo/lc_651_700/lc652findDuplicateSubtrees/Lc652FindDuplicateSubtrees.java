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

package com.lazycece.algo.lc_651_700.lc652findDuplicateSubtrees;

import com.lazycece.model.TreeNode;

import java.util.*;

/**
 * @author lazycece
 * @date 2022/9/5
 */
public class Lc652FindDuplicateSubtrees {

    private final Map<String, TreeNode> map = new HashMap<>();

    private final Set<TreeNode> res = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(res);
    }

    private String dfs(TreeNode root) {
        if (root == null) return null;
        String[] key = {String.valueOf(root.val), dfs(root.left), dfs(root.right)};
        String ks = Arrays.toString(key);
        if (map.containsKey(ks)) {
            // 用第一个的值节点，保证正确性
            res.add(map.get(ks));
        } else {
            map.put(ks, root);
        }
        return ks;
    }

    public static void main(String[] args) {
        Integer[] tree = {2, 2, 2, 3, null, 3, null};
        Lc652FindDuplicateSubtrees lc = new Lc652FindDuplicateSubtrees();

        List<TreeNode> res = lc.findDuplicateSubtrees(TreeNode.buildFromLevelOrder(tree));
        System.out.println();
    }
}
