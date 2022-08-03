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

package com.lazycece.algo.lc_1_50.lc30_findSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lazycece
 * @date 2022/7/25
 */
public class Lc30FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length==0) return res;
        int step = words[0].length();
        int n = s.length();
        if(words.length*step>n) return res;

        for(int i=0;i<step;i++){
            int l=i,r=i;
            Map<String,Integer> map = new HashMap<>();
            for(String wo:words){
                map.put(wo,map.getOrDefault(wo,0)+1);
            }
            for(int k=i;k<n-step+1;k=k+step, r = k){
                String str = s.substring(k,k+step);
                if(!map.containsKey(str)){
                    if(r-l==step*words.length) res.add(l);
                    // 滑动窗口修剪左端
                    while (l<k){
                            String t = s.substring(l,l+step);
                            map.put(t,map.get(t)+1);
                            l+=step;
                    }l=k+step;
                    continue;
                }
                if(map.get(str)==0){
                    if(r-l==step*words.length) res.add(l);
                    // 滑动窗口修剪左端
                    if(l<r) {
                        String t = s.substring(l,l+step);
                        map.put(t,map.get(t)+1);
                    }
                    l=l+step;
                    // 如果当前是满足==0的条件，那么下一步该位置依然可用，所以需要复位
                    k-=step;
                    continue;
                }
                if(map.containsKey(str)&&map.get(str)>0){
                    map.put(str,map.get(str)-1);
                }
            }
            if( r-l==step*words.length) res.add(l);
        }
        return res;
    }

    public static void main(String[] args) {
        Lc30FindSubstring lc = new Lc30FindSubstring();
//        String[] words = {"foo","bar"};
//        String s = "barfoothefoobarman";
//        String[] words = {"bar","foo","the"};
//        String s = "barfoofoobarthefoobarman";
//        String[] words = {"word","good","best","good"};
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"ababa","babab"};
//        String s = "ababababab";
        String[] words = {"aa","aa"};
        String s = "aaaaaaaaaaaaaa";
        System.out.println(lc.findSubstring(s,words));
    }
}
