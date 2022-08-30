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

package com.lazycece.algo.lc_401_450.lc448_findDisappearedNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/8/30
 */
public class Lc448FindDisappearedNumbers3 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n; //得到num值对应的下标
            nums[x] += n;   //num-1下标位置的数+n放入nums数组中
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                //因为值是[1,n]而第一个for循环经过if判断后筛选得到
                //的是有问题的下标即从0开始但值从1，所以下面用i+1
                ret.add(i + 1);//i位置上的值i+1未曾出现过
            }
        }
        return ret;
    }
}
