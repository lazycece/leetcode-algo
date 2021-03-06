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

package com.lazycece.algo.lc_551_600.lc559_maxDepth;

import com.lazycece.model.NNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 迭代法
 *
 * @author lazycece
 * @date 2022/7/2
 */
public class Lc559MaxDepth2 {

    public int maxDepth(NNode root) {
        if (root == null) return 0;
        Deque<NNode> deque = new ArrayDeque<>();
        deque.add(root);
        int dp = 0;
        while (!deque.isEmpty()) {
            dp++;
            Deque<NNode> de = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                NNode n = deque.pop();
                de.addAll(n.children);
            }
            deque.addAll(de);
        }
        return dp;
    }
}
