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

package com.lazycece.algo.lc_301_350.lc332_findItinerary;

import java.util.*;

/**
 * 字典排序 + 回溯法
 *
 * @author lazycece
 * @date 2022/7/11
 */
public class Lc332FindItinerary {


    private List<String> res = new ArrayList<>();
    // 记录图的有向边，主要考虑同一个边可能存在多次

    private Map<String, Map<String, Integer>> map = new HashMap<>();


    public List<String> findItinerary(List<List<String>> tickets) {

        for (int i = 0; i < tickets.size(); i++) {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            if (map.containsKey(from)) {
                map.get(from).put(to, map.get(from).getOrDefault(to,0) + 1);
            } else {
                // map key 自带同字符串的有序性排列 treemap 的有序性
                Map<String, Integer> toMap = new TreeMap<>();
                toMap.put(to, 1);
                map.put(from, toMap);
            }
        }
        res.add("JFK");
        dfs(tickets, "JFK");
        return res;
    }

    private boolean dfs(List<List<String>> tickets, String from) {
        if (res.size() - 1 == tickets.size()) return true;
        if (map.containsKey(from)) {
            for (Map.Entry<String, Integer> entry : map.get(from).entrySet()) {
                int cnt = entry.getValue();
                if (cnt == 0) continue;
                res.add(entry.getKey());
                entry.setValue(cnt - 1);

                if (dfs(tickets, entry.getKey())) return true;
                res.remove(res.size() - 1);
                entry.setValue(cnt);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Lc332FindItinerary lc = new Lc332FindItinerary();
        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(Arrays.asList("MUC", "LHR"));
//        tickets.add(Arrays.asList("JFK", "MUC"));
//        tickets.add(Arrays.asList("SFO", "SJC"));
//        tickets.add(Arrays.asList("LHR", "SFO"));

        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));

//        tickets.add(Arrays.asList("JFK", "SFO"));
//        tickets.add(Arrays.asList("JFK", "ATL"));
//        tickets.add(Arrays.asList("SFO", "JFK"));


        System.out.println(lc.findItinerary(tickets));
    }
}
