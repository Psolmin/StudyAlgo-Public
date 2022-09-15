import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> countMap = new HashMap<>();
        for (String s :
                participant) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            if (countMap.containsKey(s)) {
                countMap.put(s, countMap.get(s) - 1);
            }
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }

            answer = entry.getKey();
            break;
        }

        return answer;
    }
}