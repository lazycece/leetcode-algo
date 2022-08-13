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

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * dfs的过程, 将遇见的岛屿化为水
 *
 * @author lazycece
 * @date 2022/8/12
 */
public class Lc200NumIslandsBfs {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        int res =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    res++;
                    bfs(grid,i,j,m,n);
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid,int i,int j,int m, int n){
        grid[i][j]='0';
        Deque<Pair<Integer,Integer>> dq = new ArrayDeque<>();
        dq.add(new Pair<>(i,j));
        while(!dq.isEmpty()){
            Pair<Integer,Integer> pair = dq.poll();
            int x=pair.getKey(),y = pair.getValue();
            if(x-1>=0&&grid[x-1][y]=='1'){
                grid[x-1][y]='0';
                dq.add(new Pair<>(x-1,y));
            }
            if(y-1>=0&&grid[x][y-1]=='1'){
                grid[x][y-1]='0';
                dq.add(new Pair<>(x,y-1));
            }
            if(x+1<m&&grid[x+1][y]=='1'){
                grid[x+1][y]='0';
                dq.add(new Pair<>(x+1,y));
            }
            if(y+1<n&&grid[x][y+1]=='1'){
                grid[x][y+1]='0';
                dq.add(new Pair<>(x,y+1));
            }
        }
    }

}
