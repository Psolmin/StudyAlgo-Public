import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> wait = new LinkedList<>();
        for (int i : truck_weights) {
            wait.add(i);
        }
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int sum = 0;
        while (wait.size() > 0) {

            if (wait.peek() + sum - bridge.peek() <= weight) {
                int cur = wait.poll();
                sum += cur;
                bridge.add(cur);
            } else {
                bridge.add(0);
            }
            sum -= bridge.poll();
            answer++;
        }
        answer += bridge_length;

        return answer;
    }
}