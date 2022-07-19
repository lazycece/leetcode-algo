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

package com.lazycece.algo.lc_1_50.lc3_lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lazycece
 * @date 2022/7/19
 */
public class Lc3LengthOfLongestSubstring3 {

    public int lengthOfLongestSubstring(String s) {
        int max=0;
        Set<Character> set = new HashSet<>();
        int l=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            while(set.contains(ch)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch);
            max=Math.max(max,set.size());
        }
        return max;
    }

    public static void main(String[] args) {
        Lc3LengthOfLongestSubstring3 lc = new Lc3LengthOfLongestSubstring3();
        System.out.println(lc.lengthOfLongestSubstring("pwwkew"));
    }
}
