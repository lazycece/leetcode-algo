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

package com.lazycece.algo.lc_1351_1400.lc1374_generateTheString;

/**
 * @author lazycece
 * @date 2022/8/1
 */
public class Lc1374GenerateTheString {

    public String generateTheString(int n) {
        char[] res = new char[n];
        int[] fn = new int[26];
        int i;
        for(i=0;i<26&&n>0;i++,n--){
            fn[i]+=1;
        }
        while(n>=2) {
            for (i = 0; i < 26&&n>=2; i++,n-=2) {
                fn[i] += 2;
            }
        }
        if(n==1){
            if(fn[0]==0) fn[0]=1;
            else {
                fn[1]+=fn[0]+1;
                fn[0]=0;
            }
        }
        int k=0;
        for(i=0;i<26;i++){
            while(fn[i]>0){
                res[k++] = (char)('a'+i);
                fn[i]-=1;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Lc1374GenerateTheString lc = new Lc1374GenerateTheString();
        System.out.println(lc.generateTheString(95));
//        System.out.println(lc.generateTheString(4));
    }
}
