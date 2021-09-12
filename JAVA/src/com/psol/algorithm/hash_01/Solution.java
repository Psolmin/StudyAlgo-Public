package com.psol.algorithm.hash_01;

import java.util.*;

public class Solution {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String p : participant) {
            if (map.containsKey(p)) {
                map.put(p, map.get(p) + 1);
            } else {
                map.put(p, 1);
            }
        }

        for(String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        for (String k : map.keySet()) {
            if (map.get(k) != 0) {
                answer = k;
                break;
            }
        }
        return answer;
    }
}