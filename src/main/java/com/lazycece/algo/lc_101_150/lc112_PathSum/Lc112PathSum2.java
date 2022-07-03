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

package com.lazycece.algo.lc_101_150.lc112_PathSum;

import com.lazycece.model.TreeNode;

import java.util.Stack;

/**
 * 递归思想
 *
 * @author lazycece
 * @date 2022/7/3
 */
public class Lc112PathSum2 {

    private int sum = 0;


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        sum += root.val;
        if (root.left == null && root.right == null && sum == targetSum) {
            return true;
        }
        boolean l = hasPathSum(root.left, targetSum);
        boolean r = hasPathSum(root.right, targetSum);
        sum -= root.val;
        return l || r;
    }

    public static void main(String[] args) {
        Lc112PathSum2 lc = new Lc112PathSum2();
//        Integer[] tree = {1, 2, 3};
//        int targetNum = 5;
        Integer[] tree = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1};
        int targetNum = 22;
        System.out.println(lc.hasPathSum(TreeNode.buildFromLevelOrder(tree), targetNum));
    }
}
