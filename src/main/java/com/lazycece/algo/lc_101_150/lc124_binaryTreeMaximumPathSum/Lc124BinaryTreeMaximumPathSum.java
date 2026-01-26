/*
 *    Copyright 2026 lazycece<lazycece@gmail.com>
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

package com.lazycece.algo.lc_101_150.lc124_binaryTreeMaximumPathSum;

import com.lazycece.model.TreeNode;

/**
 * @author lazycece
 * @date 2026/1/26
 */
public class Lc124BinaryTreeMaximumPathSum {

    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        rec(root);
        return maxValue;
    }

    private int rec(TreeNode root) {
        if(root == null) return 0;
        int maxLeft = Math.max(rec(root.left), 0);
        int maxRight =Math.max(rec(root.right), 0);

        maxValue = Math.max(maxValue, maxLeft + maxRight + root.val);

        return Math.max(maxLeft, maxRight) + root.val;
    }

}
