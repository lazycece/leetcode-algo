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
import javafx.util.Pair;

import java.util.*;

/**
 * 利用给最小同子树设置同序号问题
 *
 * @author lazycece
 * @date 2022/9/6
 */
public class Lc652FindDuplicateSubtrees2 {

    Map<String, Pair<TreeNode, Integer>> seen = new HashMap<String, Pair<TreeNode, Integer>>();
    Set<TreeNode> repeat = new HashSet<TreeNode>();
    int idx = 0;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<TreeNode>(repeat);
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int[] tri = {node.val, dfs(node.left), dfs(node.right)};
        String hash = Arrays.toString(tri);
        if (seen.containsKey(hash)) {
            Pair<TreeNode, Integer> pair = seen.get(hash);
            repeat.add(pair.getKey());
            return pair.getValue();
        } else {
            seen.put(hash, new Pair<TreeNode, Integer>(node, ++idx));
            return idx;
        }
    }

    public static void main(String[] args) {
        Integer[] tree = {2, 2, 2, 3, null, 3, null};
        Lc652FindDuplicateSubtrees2 lc = new Lc652FindDuplicateSubtrees2();

        List<TreeNode> res = lc.findDuplicateSubtrees(TreeNode.buildFromLevelOrder(tree));
        System.out.println();
    }
}
