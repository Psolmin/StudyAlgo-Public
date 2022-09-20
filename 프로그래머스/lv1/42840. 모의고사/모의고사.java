import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();

        // 1 : 1, 2, 3, 4, 5
        int[] temp = {1, 2, 3, 4, 5};
        int[] a1 = new int[40];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = temp[i % temp.length];
        }
        // 2 : 2, 1, 2, 3, 2, 4, 2, 5
        temp = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] a2 = new int[40];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = temp[i % temp.length];
        }

        // 3 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
        temp = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] a3 = new int[40];
        for (int i = 0; i < a3.length; i++) {
            a3[i] = temp[i % temp.length];
        }

        int[] sol = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a1[i % a1.length]) {
                sol[0]++;
            }
            if (answers[i] == a2[i % a2.length]) {
                sol[1]++;
            }
            if (answers[i] == a3[i % a3.length]) {
                sol[2]++;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i : sol) {
            if (i > max) {
                max = i;
            }
        }

        for (int i = 0; i < sol.length; i++) {
            if (max == sol[i]) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}