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

package com.lazycece.algo.lc_501_550.lc501_findMode;

import com.lazycece.model.TreeNode;

import java.util.*;

/**
 * @author lazycece
 * @date 2022/7/4
 */
public class Lc501FindMode {

    public int[] findMode(TreeNode root) {
        if (root == null) throw new IllegalArgumentException("param error");
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        Map<Integer, Integer> map = new HashMap<>();
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t != null) {
                if (t.right != null) stack.add(t.right);
                stack.add(t);
                stack.add(null);
                if (t.left != null) stack.add(t.left);
            } else {
                t = stack.pop();
                if (map.containsKey(t.val)) {
                    map.put(t.val, map.get(t.val) + 1);
                } else {
                    map.put(t.val, 1);
                }
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int max = list.get(list.size() - 1);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        int[] re = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            re[i] = result.get(i);
        }
        return re;
    }
}
