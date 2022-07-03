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

package com.lazycece.algo.lc_101_150.lc110_isBalanced;

import com.lazycece.model.TreeNode;

/**
 * 有反例直接中断
 *
 * @author lazycece
 * @date 2022/7/2
 */
public class Lc110IsBalanced1 {

    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        helper(root);
        return flag;
    }

    private int helper(TreeNode t) {
        if (!flag) {
            // 提前中断
            return 1;
        }
        // 获取子树高度
        if (t == null) return 0;
        int left = helper(t.left) + 1;
        int right = helper(t.right) + 1;
        // 判断子树是否balance
        if (flag) flag = Math.abs(left - right) <= 1;
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Lc110IsBalanced1 lc = new Lc110IsBalanced1();
//        Integer[] tree = {3, 9, 20, null, null, 15, 7};
//        Integer[] tree = {1, 2, 2, 3, 3, null, null, 4, 4};
        Integer[] tree = {1};
        System.out.println(lc.isBalanced(TreeNode.buildFromLevelOrder(tree)));
    }
}
