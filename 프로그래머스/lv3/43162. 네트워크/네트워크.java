import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visit[i] == false) {
                answer++;
            
                visit[i] = true;
                queue.offer(i);
            
                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int j = 0; j < computers[node].length; j++) {
                        if (computers[node][j] == 1 && visit[j] == false) {
                            visit[j] = true;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}