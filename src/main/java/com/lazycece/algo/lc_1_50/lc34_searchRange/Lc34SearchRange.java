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

package com.lazycece.algo.lc_1_50.lc34_searchRange;

import com.lazycece.utils.ArrayUtils;

/**
 * @author lazycece
 * @date 2022/8/3
 */
public class Lc34SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int begin = -1, end = -1;
        while (l <= r) {
            if (nums[l] == target) {
                while (l <= r && nums[l] == target) {
                    if (begin == -1) begin = l;
                    end = l;
                    l++;
                }
                break;
            }
            if (nums[r] == target) {
                while (l <= r && nums[r] == target) {
                    if (end == -1) end = r;
                    begin = r;
                    r--;
                }
                break;
            }
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                begin = mid;
                end = mid;
                int ll = mid, rr = mid;
                while (l <= ll && nums[ll] == target) {
                    begin = ll;
                    ll--;
                }
                while (rr <= r && nums[rr] == target) {
                    end = rr;
                    rr++;
                }
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int[] res = {-1, -1};
        if (begin != -1 && end != -1) {
            res[0] = begin;
            res[1] = end;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc34SearchRange lc = new Lc34SearchRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        ArrayUtils.print(lc.searchRange(nums, target));
    }
}
