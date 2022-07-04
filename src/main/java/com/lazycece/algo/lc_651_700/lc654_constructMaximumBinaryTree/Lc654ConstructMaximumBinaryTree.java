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

package com.lazycece.algo.lc_651_700.lc654_constructMaximumBinaryTree;

import com.lazycece.model.TreeNode;

/**
 * 递归+双指针
 *
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc654ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        int max = -1;
        int index = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode t = new TreeNode(max);
        if (index > l) t.left = constructMaximumBinaryTree(nums, l, index - 1);
        if (index < r) t.right = constructMaximumBinaryTree(nums, index + 1, r);
        return t;
    }

    public static void main(String[] args) {
        Lc654ConstructMaximumBinaryTree lc = new Lc654ConstructMaximumBinaryTree();
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode t = lc.constructMaximumBinaryTree(nums);
        System.out.println();
    }
}
