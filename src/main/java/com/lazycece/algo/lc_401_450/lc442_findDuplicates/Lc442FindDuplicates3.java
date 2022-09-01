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

package com.lazycece.algo.lc_401_450.lc442_findDuplicates;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/9/1
 */
public class Lc442FindDuplicates3 {

    public List<Integer> findDuplicates(int[] nums) {
        // 利用出现两次的特性，用正负性进行标识
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index - 1] > 0) {
                nums[index - 1] = -nums[index - 1];
            } else {
                res.add(index);
            }
        }
        return res;
    }
}
