import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for (int[] command : commands) {
            List<Integer> sorted = new ArrayList<>();
            for (int i = command[0] - 1; i < command[1]; i++) {
                sorted.add(array[i]);
            }
            Collections.sort(sorted);
            answer.add(sorted.get(command[2] - 1));

        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}