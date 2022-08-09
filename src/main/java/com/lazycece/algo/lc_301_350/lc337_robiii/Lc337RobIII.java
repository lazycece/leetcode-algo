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

package com.lazycece.algo.lc_301_350.lc337_robiii;

import com.lazycece.model.TreeNode;


/**
 * @author lazycece
 * @date 2022/8/9
 */
public class Lc337RobIII {

    int y = 0, n = 0;

    public int rob(TreeNode root) {
        helper(root);
        return Math.max(y, n);
    }

    private void helper(TreeNode t) {
        if (t == null) {
            y = 0;
            n = 0;
            return;
        }
        helper(t.left);
        int ly = y, ln = n;
        helper(t.right);
        int ry = y, rn = n;
        y = ln + rn + t.val;
        n = Math.max(ly, ln) + Math.max(ry, rn);
    }


    public static void main(String[] args) {
        Lc337RobIII lc = new Lc337RobIII();
        Integer[] t = {2, 1, 3, null, 4};
//        Integer[] t = {3,4,5,1,3,null,1};

        System.out.println(lc.rob(TreeNode.buildFromLevelOrder(t)));

    }
}
