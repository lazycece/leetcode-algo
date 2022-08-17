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

package com.lazycece.algo.lc_151_200.lc169_majorityElement;


/**
 * 空间复杂度o1
 *
 * @author lazycece
 * @date 2022/8/17
 */
public class Lc169MajorityElement3 {

    public int majorityElement(int[] nums) {
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) res = nums[i];
            // 投票思路
            cnt += nums[i] == res ? 1 : -1;
        }
        return res;
    }
}
