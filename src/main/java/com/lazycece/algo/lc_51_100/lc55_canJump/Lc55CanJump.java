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

package com.lazycece.algo.lc_51_100.lc55_canJump;

/**
 * dp
 * dp[i]==1 , can arrive
 * dp[i]==0, can not arrive
 *
 * @author lazycece
 * @date 2022/8/3
 */
public class Lc55CanJump {

    public boolean canJump(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        dp[0]=1;
        for(int i=0;i<n;i++){
            // 当不能道道此地时直接跳过，表示当前位置无法走，
            // 去遍历后续位置是否可以达到以及是否能继续走下去
            if(dp[i]==0) continue;
            for(int j=1;j<=nums[i]&&i+j<n;j++){
                // 可达性标记
                dp[i+j]=1;
            }
            // 如果提前可以到达，就结束跳跃
            if(dp[n-1]==1) return true;
        }
        return dp[n-1]==1;
    }
}
