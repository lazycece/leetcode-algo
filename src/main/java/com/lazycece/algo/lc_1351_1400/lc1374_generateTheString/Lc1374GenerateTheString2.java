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
public class Lc1374GenerateTheString2 {

    public String generateTheString(int n) {
        char[] res = new char[n];
        int m=0,k=0;
        if(n%2==0){
            m=n-1;
            k=1;
        }else {
            m=n;
        }
        int i=0;
        for(;i<m;i++){
            res[i]='a';
        }
        if(k==1) res[i]='b';
        return new String(res);
    }

    public static void main(String[] args) {
        Lc1374GenerateTheString2 lc = new Lc1374GenerateTheString2();
        System.out.println(lc.generateTheString(96));
//        System.out.println(lc.generateTheString(4));
    }
}
