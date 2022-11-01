import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visit = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                continue;
            }
            queue.add(i);
            answer++;

            while (!queue.isEmpty()) {
                int computer = queue.poll();
                if (visit[computer]) {
                    continue;
                }
                visit[computer] = true;

                for (int j = 0; j < computers[computer].length; j++) {
                    if (visit[j] || computers[computer][j] == 0) {
                        continue;
                    }
                    queue.offer(j);
                }
            }
        }

        return answer;
    }
}