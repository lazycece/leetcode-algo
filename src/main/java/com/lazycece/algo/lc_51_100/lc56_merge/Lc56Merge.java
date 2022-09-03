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

package com.lazycece.algo.lc_51_100.lc56_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lazycece
 * @date 2022/9/4
 */
public class Lc56Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2)->o1[0]-o2[0]);
        List<Integer[]> list  = new ArrayList<>();
        int begin=intervals[0][0], end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end = Math.max(end,intervals[i][1]);
            }else{
                list.add(new Integer[]{begin,end});
                begin = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new Integer[]{begin,end});
        int[][] res = new int[list.size()][2];
        int i=0;
        for(Integer[] arr : list){
            res[i][0]= arr[0];
            res[i][1]= arr[1];
            i++;
        }
        return res;
    }
}
