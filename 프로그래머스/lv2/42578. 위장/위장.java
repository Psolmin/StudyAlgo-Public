import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clothCount = new HashMap<>();
        for (String[] str : clothes) {
            clothCount.put(str[1], clothCount.getOrDefault(str[1], 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : clothCount.entrySet()) {
            answer *= entry.getValue() + 1;
        }

        return answer - 1;
    }
}