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

package com.lazycece.algo.lc_401_450.lc404_sumOfLeftLeaves;

import com.lazycece.model.TreeNode;

/**
 * @author lazycece
 * @date 2022/7/3
 */
public class Lc404SumOfLeftLeaves {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return sum;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);

        return sum;
    }

    public static void main(String[] args) {
        Lc404SumOfLeftLeaves lc = new Lc404SumOfLeftLeaves();
        Integer[] tree = {3, 9, 20, null, null, 15, 7};
//        Integer[] tree = {1};
        System.out.println(lc.sumOfLeftLeaves(TreeNode.buildFromLevelOrder(tree)));
    }
}
