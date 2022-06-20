package com.psol.algorithm.로또의_최고_순위와_최저_순위;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] winning = {6, 6, 5, 4, 3, 2, 1};
        Arrays.sort(win_nums);
        Arrays.sort(lottos);

        int same = 0;
        int zero = 0;

        for (int i = 5; i >= 0; i--) {
            if (lottos[i] == 0) {
                zero++;
            } else {
                for (int j = 5; j >= 0; j--) {
                    if (lottos[i] == win_nums[j]) {
                        same++;
                        break;
                    } else if (lottos[i] > win_nums[j]) {
                        break;
                    }
                }
            }

        }
//        System.out.println(winning[same + zero] + " " + winning[same]);
//        int[] answer = new int[2];
//        answer[0] = winning[same + zero];
//        answer[1] = winning[same];
//        return answer;

        return new int[] {winning[same + zero], winning[same]};
    }
}
