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

package com.lazycece.algo.lc_1_50.lc22_generateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/9/4
 */
public class Lc22GenerateParenthesis {

    private List<String> res = new ArrayList<>();
    private int len = 0;

    public List<String> generateParenthesis(int n) {
        len = 2 * n;
        dfs("", n, n);
        return res;
    }

    private void dfs(String str, int ln, int rn) {
        if (str.length() == len) {
            res.add(str);
            return;
        }
        if (ln > 0) {
            dfs(str + "(", ln - 1, rn);
        }
        // 右括号必须要大于做括号，符合成对特性
        if (rn > ln) {
            dfs(str + ")", ln, rn - 1);
        }
    }
}
