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

package com.lazycece.algo.lc_651_700.lc687_longestUnivaluePath;

import com.lazycece.model.TreeNode;

/**
 * @author lazycece
 * @date 2022/9/2
 */
public class Lc687LongestUnivaluePath {

    int len = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return len;
        int llen = helper(root.left, root.val);
        int rlen = helper(root.right, root.val);
        // 因为没有父节点，所以用左右len相加
        return Math.max(len, llen + rlen);
    }

    public int helper(TreeNode root, int val) {
        if (root == null) return 0;
        int llen = helper(root.left, root.val);
        int rlen = helper(root.right, root.val);
        len = Math.max(len, llen + rlen);
        if (root.val == val) {
            // 归属父节点，即加1
            return Math.max(llen, rlen) + 1;
        }
        return 0;
    }


}
