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

package com.lazycece.algo.lc_151_200.lc200_numIslands;

/**
 * dfs的过程, 将遇见的岛屿化为水
 *
 * @author lazycece
 * @date 2022/8/12
 */
public class Lc200NumIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        int res =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(i,j,grid,m,n);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j,char[][] grid,int m,int n){
        if(grid[i][j]=='0') return;
        grid[i][j]='0';
        if(j-1>=0){
            dfs(i,j-1,grid,m,n);
        }
        if(j+1<n){
            dfs(i,j+1,grid,m,n);
        }
        if(i+1<m){
            dfs(i+1,j,grid,m,n);
        }
        if(i-1>=0){
            dfs(i-1,j,grid,m,n);
        }
    }
}
