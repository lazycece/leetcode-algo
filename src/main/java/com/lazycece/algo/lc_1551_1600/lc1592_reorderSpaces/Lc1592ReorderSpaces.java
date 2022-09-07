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

package com.lazycece.algo.lc_1551_1600.lc1592_reorderSpaces;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/9/7
 */
public class Lc1592ReorderSpaces {

    public String reorderSpaces(String text) {
        int count = 0;
        int begin = -1, end = -1;
        boolean flag = false;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                count++;
                if (flag) {
                    flag = false;
                    end = i;
                    list.add(text.substring(begin, end));
                }
            } else if (ch != ' ' && !flag) {
                flag = true;
                begin = i;
            }
        }
        if (flag) list.add(text.substring(begin));
        int cnt = list.size() > 1 ? count / (list.size() - 1) : 0;
        int ys = list.size() > 1 ? count % (list.size() - 1) : count;
        String temp = "";
        while (cnt-- > 0) {
            temp += " ";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) sb.append(temp);
        }
        while (ys-- > 0) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
