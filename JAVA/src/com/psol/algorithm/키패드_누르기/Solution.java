package com.psol.algorithm.키패드_누르기;

import java.util.*;

public class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();
        Map<Integer, int[]> move = new HashMap<>();
        move.put(2, new int[]{3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 4});
        move.put(5, new int[]{2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 3});
        move.put(8, new int[]{1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 2});
        move.put(0, new int[]{0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 1});

        List<Integer> leftNum = new ArrayList<>(Arrays.asList(1, 4, 7));
        List<Integer> rightNum = new ArrayList<>(Arrays.asList(3, 6, 9));

        int curLeft = 10;
        int curRight = 11;
        for (int number : numbers) {
            if (leftNum.contains(number)) {
                answer.append("L");
                curLeft = number;
            } else if (rightNum.contains(number)) {
                answer.append("R");
                curRight = number;
            } else {
                int[] curMove = move.get(number);
                if (curMove[curLeft] < curMove[curRight]) {
                    answer.append("L");
                    curLeft = number;
                } else if (curMove[curLeft] > curMove[curRight]) {
                    answer.append("R");
                    curRight = number;
                } else {
                    if ("right".equals(hand)) {
                        answer.append("R");
                        curRight = number;
                    } else {
                        answer.append("L");
                        curLeft = number;
                    }
                }


            }
        }
        return answer.toString();
    }
}