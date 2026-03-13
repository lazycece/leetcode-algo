/*
 *    Copyright 2026 lazycece<lazycece@gmail.com>
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

package com.lazycece.algo.lc_751_800;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2026/3/13
 */
public class Lc753PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> resultList = new ArrayList<>();
        // 先计算每个字符的最大下标位置
        int[] charMaxIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charMaxIndex[s.charAt(i) - 'a'] = i;
        }
        int i = 0;
        while (i < s.length()) {
            // 寻找拆分出的单个字符串的最后下标位置
            int maxIndex = charMaxIndex[s.charAt(i) - 'a'];
            int j = i + 1;
            while (j < maxIndex) {
                maxIndex = Math.max(maxIndex, charMaxIndex[s.charAt(j) - 'a']);
                j++;
            }
            resultList.add(maxIndex - i + 1);
            // 进行下一轮处理
            i = maxIndex + 1;
        }
        return resultList;
    }
}
