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

package com.lazycece.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/2/27
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildFromLevelOrder(Integer[] arr) {
        // { 1,2,3,4,5,6,7,8,null }
        if (arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        buildFromLevelOrder(root, 0, arr);
        return root;
    }

    private static void buildFromLevelOrder(TreeNode t, int i, Integer[] arr) {
        if (t == null) {
            return;
        }
        int l = 2 * i + 1;
        if (l < arr.length && arr[l] != null) {
            t.left = new TreeNode(arr[l]);
            buildFromLevelOrder(t.left, l, arr);
        }

        int r = 2 * i + 2;
        if (r < arr.length && arr[r] != null) {
            t.right = new TreeNode(arr[r]);
            buildFromLevelOrder(t.right, r, arr);
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }
}
