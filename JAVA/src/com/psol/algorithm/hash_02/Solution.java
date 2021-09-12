package com.psol.algorithm.hash_02;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) map.put(phone_book[i], i);

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }
}