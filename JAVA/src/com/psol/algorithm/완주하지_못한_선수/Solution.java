package com.psol.algorithm.완주하지_못한_선수;
import java.util.*;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> ans = new HashMap<String, Integer>();
        for (String p : participant) {
            if (ans.containsKey(p)) {
                int val = ans.get(p) + 1;
                ans.put(p, val);
            } else {
                ans.put(p, 1);
            }
        }

        for(String c : completion) {
            int val = ans.get(c) - 1;
            ans.put(c, val);
        }

        for (String find : ans.keySet()) {
            if (ans.get(find) == 1) {
                answer = find;
                break;
            }
        }
        return answer;
    }
}