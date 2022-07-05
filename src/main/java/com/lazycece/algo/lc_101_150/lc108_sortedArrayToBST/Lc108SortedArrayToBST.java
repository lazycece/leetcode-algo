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

package com.lazycece.algo.lc_101_150.lc108_sortedArrayToBST;

import com.lazycece.model.TreeNode;

/**
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc108SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        int mid = (high - low + 1) / 2 + low;
        TreeNode t = new TreeNode(nums[mid]);
        if (mid > low) t.left = sortedArrayToBST(nums, low, mid - 1);
        if (mid < high) t.right = sortedArrayToBST(nums, mid + 1, high);
        return t;
    }

    public static void main(String[] args) {
        Lc108SortedArrayToBST lc = new Lc108SortedArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode t = lc.sortedArrayToBST(nums);
        System.out.println();
    }
}
