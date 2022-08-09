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
public class Lc337RobIII2 {

    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode t) {
        if (t == null) {
            return new int[]{0, 0};
        }
        int[] l = helper(t.left);
        int[] r = helper(t.right);
        int y = l[1] + r[1] + t.val;
        int n = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{y, n};
    }


    public static void main(String[] args) {
        Lc337RobIII2 lc = new Lc337RobIII2();
        Integer[] t = {2, 1, 3, null, 4};
//        Integer[] t = {3,4,5,1,3,null,1};

        System.out.println(lc.rob(TreeNode.buildFromLevelOrder(t)));

    }
}
