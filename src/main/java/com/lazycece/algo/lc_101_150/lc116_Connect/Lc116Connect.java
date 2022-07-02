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

package com.lazycece.algo.lc_101_150.lc116_Connect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/7/2
 */
public class Lc116Connect {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<Node> le = new ArrayList<>();
            int i = 0;
            for (; i < level.size(); i++) {
                Node n = level.get(i);
                if (n.left != null) le.add(n.left);
                if (n.right != null) le.add(n.right);
                if (i == level.size() - 1) break;
                n.next = level.get(i + 1);
            }
            level.get(i).next = null;
            level.clear();
            level.addAll(le);
        }
        return root;
    }

    public static class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }
}
