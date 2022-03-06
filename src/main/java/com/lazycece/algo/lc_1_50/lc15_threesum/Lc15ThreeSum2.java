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

package com.lazycece.algo.lc_1_50.lc15_threesum;

import java.util.*;

/**
 * 转换为双指针思想：
 *
 * 排序;
 * 确定a，寻找 a + b + c = 0;
 * 双指针即为 b, c;
 * 注意手动去重；因为确定三数和为0，那么a>0即可提前结束；
 *
 * @author lazycece
 * @date 2022/2/16
 */
public class Lc15ThreeSum2 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }

            int m = i + 1, n = nums.length - 1;
            while (m < n) {
                if (n<nums.length-1&&nums[n]==nums[n+1]||nums[i] + nums[m] + nums[n] > 0) {
                    n--;
                } else if (m>i+1&&nums[m]==nums[m-1]||nums[i] + nums[m] + nums[n] < 0) {
                    m++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[m++]);
                    list.add(nums[n--]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = new Lc15ThreeSum2().threeSum(nums);
        System.out.println(result);
    }
}
