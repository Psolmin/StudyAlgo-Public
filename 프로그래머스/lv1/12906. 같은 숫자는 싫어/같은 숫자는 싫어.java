import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // int[] answer = {};
        List<Integer> answer = new ArrayList<>();
        int cur = -1;
        for (int i : arr) {
            if (i == cur) {
                continue;
            }
            cur = i;
            
            answer.add(i);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}