import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int index = queue.poll();
                
                answer[index]++;
                if (prices[i] >= prices[index]) {
                    queue.offer(index);
                }
            }
            queue.offer(i);
        }

        return answer;
    }
}