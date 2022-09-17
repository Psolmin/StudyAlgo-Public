import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>(Arrays.stream(priorities).boxed().collect(Collectors.toList()));

        Queue<Integer> index = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            index.add(i);
        }

        Arrays.sort(priorities);

        int maxIndex = priorities.length - 1;
        int maxValue = priorities[maxIndex];
        while (true) {
            int v = queue.poll();
            int i = index.poll();

            if (v != maxValue) {
                queue.offer(v);
                index.offer(i);
            } else {
                answer++;

                if (i == location) {
                    return answer;
                }
                maxValue = priorities[--maxIndex];
            }
        }
    }
}