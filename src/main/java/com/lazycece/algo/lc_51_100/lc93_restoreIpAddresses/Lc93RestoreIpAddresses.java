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

package com.lazycece.algo.lc_51_100.lc93_restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/7/9
 */
public class Lc93RestoreIpAddresses {


    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        helper(s, 0, 4, "");
        return res;
    }

    private void helper(String s, int index, int k, String str) {

        if (k == 0) {
            // 如果满足了k个段，且字符串遍历完毕，则结束
            if (s.length() == index) {
                res.add(str.substring(0, str.length() - 1));
            }
            return;
        }

        for (int i = index; i < s.length() - k + 1; i++) {
            int first = Integer.parseInt(s.substring(index, index + 1));
            // 如果0开头的非各位数情况，结束遍历
            if (i != index && first == 0) {
                break;
            }
            // 控制树的遍历长度在 [1,3]的范围
            if (i - index >= 3) break;
            int val = Integer.parseInt(s.substring(index, i + 1));
            if (val <= 255) {
                helper(s, i + 1, k - 1, str + val + ".");
            }
        }
    }

    public static void main(String[] args) {
        Lc93RestoreIpAddresses lc = new Lc93RestoreIpAddresses();
//        System.out.println(lc.restoreIpAddresses("25525511135"));
//        System.out.println(lc.restoreIpAddresses("0000"));
//        System.out.println(lc.restoreIpAddresses("101023"));

        System.out.println(lc.restoreIpAddresses("1231231231234"));

    }
}
