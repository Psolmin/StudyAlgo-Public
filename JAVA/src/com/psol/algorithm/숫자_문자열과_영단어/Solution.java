package com.psol.algorithm.숫자_문자열과_영단어;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String s) {
        String temp = s;
        temp = temp.replaceAll("zero", "0");
        temp = temp.replaceAll("one", "1");
        temp = temp.replaceAll("two", "2");
        temp = temp.replaceAll("three", "3");
        temp = temp.replaceAll("four", "4");
        temp = temp.replaceAll("five", "5");
        temp = temp.replaceAll("six", "6");
        temp = temp.replaceAll("seven", "7");
        temp = temp.replaceAll("eight", "8");
        temp = temp.replaceAll("nine", "9");

        return Integer.parseInt(temp);
    }
}