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

package com.lazycece.algo.lc_351_400.lc377_combinationSum4;

import java.util.HashMap;
import java.util.Map;

/**
 * 回溯递归----记忆化
 * <p>
 * 因为每次的target都可以用整个数组进行计算，所以，target的结果是可以存储的
 * </p>
 *
 * @author lazycece
 * @date 2022/7/8
 */
public class Lc377CombinationSum42 {

    Map<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        if (map.containsKey(target)) return map.get(target);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            target -= nums[i];
            res += combinationSum4(nums, target);
            target += nums[i];
        }
        map.put(target, res);
        return res;
    }

    public static void main(String[] args) {
        Lc377CombinationSum42 lc = new Lc377CombinationSum42();
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(lc.combinationSum4(nums, target));
    }
}
