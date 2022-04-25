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

package com.lazycece.algo.lc_101_150.lc109_ConvertSortedListToBinarySearchTree;

import com.lazycece.model.ListNode;
import com.lazycece.model.TreeNode;

import java.util.Arrays;

/**
 * @author lazycece
 * @date 2022/2/27
 */
public class Lc109ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        Lc109ConvertSortedListToBinarySearchTree lc109 = new Lc109ConvertSortedListToBinarySearchTree();
        TreeNode treeNode = lc109.sortedListToBST(ListNode.build(Arrays.asList(-10, -3, 0, 5, 9)));
        TreeNode treeNode2 = lc109.sortedListToBST(ListNode.build(Arrays.asList(0, 1, 2, 3, 4, 5)));

        System.out.println();
    }
}
