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

package com.lazycece.algo.lc_101_150.lc113_pathSumii;

import com.lazycece.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 递归思路
 *
 * @author lazycece
 * @date 2022/7/3
 */
public class Lc113PathSumii2 {

    private int num = 0;
    private Stack<Integer> list = new Stack<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return result;
        num += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && num == targetSum) {
            result.add(new ArrayList<>(list));
        } else {
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
        }
        num -= root.val;
        list.pop();
        return result;
    }

    public static void main(String[] args) {
        Lc113PathSumii2 lc = new Lc113PathSumii2();
        Integer[] tree = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1};
        int targetNum = 22;
        System.out.println(lc.pathSum(TreeNode.buildFromLevelOrder(tree), targetNum));
    }
}
