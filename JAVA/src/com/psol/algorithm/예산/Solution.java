package com.psol.algorithm.예산;

import java.util.Arrays;

public class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i : d) {
            if (i <= budget) {
                budget -= i;
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}