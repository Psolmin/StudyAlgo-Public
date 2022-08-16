package com.psol.algorithm.최소직사각형;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int x = -1;
        int y = -1;
        for (int[] size : sizes) {
            Arrays.sort(size);

            if (size[0] > x) {
                x = size[0];
            }

            if (size[1] > y) {
                y = size[1];
            }
        }
        return x * y;
    }
}
