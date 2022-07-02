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

package com.lazycece.algo.lc_501_550.lc515_FindLargestValueInEachTreeRow;

import com.lazycece.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/7/2
 */
public class Lc515FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<TreeNode> l = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (TreeNode t : level) {
                max = Math.max(max, t.val);
                if (t.left != null) l.add(t.left);
                if (t.right != null) l.add(t.right);
            }
            result.add(max);
            level.clear();
            level.addAll(l);
        }
        return result;
    }

    public static void main(String[] args) {
        Lc515FindLargestValueInEachTreeRow lc = new Lc515FindLargestValueInEachTreeRow();
        Integer[] tree = {1, 3, 2, 5, 3, null, 9};
        System.out.println(lc.largestValues(TreeNode.buildFromLevelOrder(tree)));
    }
}
