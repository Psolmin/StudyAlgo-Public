import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            list.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }

        int pre = list.get(0);
        int count = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= pre) {
                count++;
            } else {
                answer.add(count);
                pre = list.get(i);
                count = 1;
            }
        }
        answer.add(count);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}