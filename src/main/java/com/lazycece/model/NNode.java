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

import java.util.List;

/**
 * @author lazycece
 * @date 2022/7/2
 */
public class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {
    }

    public NNode(int val) {
        this.val = val;
    }

    public NNode(int val, List<NNode> children) {
        this.val = val;
        this.children = children;
    }
}
