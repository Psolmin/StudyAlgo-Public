import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.stream(scoville).boxed().collect(Collectors.toList()));

        while (pq.peek() < K) {
            if (pq.size() < 2 && pq.peek() < K) {
                return -1;
            }
            int mix = pq.poll() + (pq.poll() * 2);
            pq.add(mix);
            answer++;
        }

        return answer;
    }
}