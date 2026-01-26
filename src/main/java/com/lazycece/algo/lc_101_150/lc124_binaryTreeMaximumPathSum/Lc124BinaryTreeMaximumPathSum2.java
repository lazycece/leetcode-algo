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
public class Lc124BinaryTreeMaximumPathSum2 {

    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        return Math.max(rec(root) , maxValue);
    }

    private int rec(TreeNode root) {
        if(root == null) return 0;
        int maxLeft = rec(root.left);
        int maxRight = rec(root.right);

        int ll = maxLeft + root.val;
        int rl = maxRight + root.val;
        int ol = maxLeft + maxRight + root.val;
        int mLen = Math.max(Math.max(ll,rl), ol );

        maxValue = Math.max(maxValue, Math.max(mLen, root.val));

        int maxChild = Math.max(maxLeft, maxRight);
        return maxChild > 0 ? maxChild + root.val : root.val;
    }

}
