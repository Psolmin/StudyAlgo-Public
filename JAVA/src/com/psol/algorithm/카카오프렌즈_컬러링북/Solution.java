package com.psol.algorithm.카카오프렌즈_컬러링북;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                if ()

                System.out.print(picture[i][j]);
            }
            System.out.println();
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    void serch(int i, int j, int[][] picture, boolean[][] visit) {
//        if ()
    }
}