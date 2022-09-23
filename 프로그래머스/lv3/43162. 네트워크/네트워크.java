import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    list.add(j);
                }
            }
            graph.put(i, list);
        }

        boolean[] visit = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                continue;
            }
            q.add(i);
            answer++;

            while (!q.isEmpty()) {
                int computer = q.poll();
                if (visit[computer]) {
                    continue;
                }
                visit[computer] = true;

                List<Integer> list = graph.get(computer);
                for (int c : list) {
                    q.add(c);
                }

            }
        }

        return answer;
    }
}