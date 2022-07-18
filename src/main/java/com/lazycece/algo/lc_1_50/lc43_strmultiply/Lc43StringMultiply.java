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

package com.lazycece.algo.lc_1_50.lc43_strmultiply;

/**
 * @author lazycece
 * @date 2022/2/17
 */
public class Lc43StringMultiply {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int offset = 0;
        String res = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int ofs = 0;
            String forAdd = "";
            for (int j = num2.length() - 1; j >= 0; j--) {
                String tmp = multiply(num1.charAt(i), num2.charAt(j));
                forAdd = add(tmp, forAdd, ofs);
                ofs++;
            }
            res = add(forAdd, res, offset);
            offset++;
        }
        return res;
    }

    private String multiply(char a, char b) {
        int intA = Integer.parseInt(String.valueOf(a));
        int intB = Integer.parseInt(String.valueOf(b));
        return String.valueOf(intA * intB);
    }

    private String add(String ofsNum, String num, int ofs) {
        for (int i = 1; i <= ofs; i++) {
            ofsNum += "0";
        }
        int up = 0;
        String res = "";
        int ofsNumOfs = ofsNum.length() - num.length();
        for (int i = num.length() - 1; i >= 0; i--) {
            int intA = Integer.parseInt(String.valueOf(num.charAt(i)));
            int intB = Integer.parseInt(String.valueOf(ofsNum.charAt(i + ofsNumOfs)));
            int sum = intA + intB + up;
            if (sum >= 10) {
                up = 1;
                res = String.valueOf(sum % 10) + res;
            } else {
                up = 0;
                res = String.valueOf(sum) + res;
            }
        }
        if (ofsNumOfs > 0) {
            for (int i = ofsNumOfs - 1; i >= 0; i--) {
                int tmp = Integer.parseInt(String.valueOf(ofsNum.charAt(i)));
                int sum = tmp + up;
                if (sum >= 10) {
                    up = 1;
                    res = String.valueOf(sum % 10) + res;
                } else {
                    up = 0;
                    res = String.valueOf(sum) + res;
                }
            }
        }
        if (up == 1) {
            // 注意最后的进位
            res = "1" + res;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc43StringMultiply lc = new Lc43StringMultiply();
//        System.out.println(lc.multiply("2", "3"));
//        System.out.println(lc.multiply("123", "456"));
        System.out.println(lc.multiply("0", "9"));
        System.out.println(lc.multiply("9133", "0"));
    }

}
