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

/**
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc530MinimumDifference {

    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) throw new IllegalArgumentException("param error");
        helper(root, null, null);
        return min;
    }

    private void helper(TreeNode root, Integer low, Integer up) {
        if (root == null) return;
        if (low != null) min = Math.min(min, root.val - low);
        if (up != null) min = Math.min(min, up - root.val);
        helper(root.left, low, root.val);
        helper(root.right, root.val, up);
    }

    public static void main(String[] args) {
        Lc530MinimumDifference lc = new Lc530MinimumDifference();
//        Integer[] tree = {1, 0, 48, null, null, 12, 49};
        Integer[] tree = {4, 2, 6, 1, 3};
        System.out.println(lc.getMinimumDifference(TreeNode.buildFromLevelOrder(tree)));
    }
}
