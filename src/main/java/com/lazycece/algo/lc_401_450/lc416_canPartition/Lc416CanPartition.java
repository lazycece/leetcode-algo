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

package com.lazycece.algo.lc_401_450.lc416_canPartition;

/**
 * 数组个数不多的时候可以用回溯法解决
 *
 * @author lazycece
 * @date 2022/7/13
 */
public class Lc416CanPartition {

    public boolean canPartition(int[] nums) {
        // 数量小于2，无法拆分2个子集
        if (nums.length < 2) return false;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        // 奇数无法拆分两个和
        if (sum % 2 != 0) return false;
        int subNum = sum / 2;
        return dfs(subNum, nums, 0);
    }

    private boolean dfs(int subNum, int[] nums, int index) {
        if (subNum == 0) return true;
        if (subNum < 0) return false;
        for (int i = index; i < nums.length; i++) {
            if (dfs(subNum - nums[i], nums, i + 1)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Lc416CanPartition lc = new Lc416CanPartition();
        int[] nums = {1, 5, 11, 5};
        System.out.println(lc.canPartition(nums));
    }
}
