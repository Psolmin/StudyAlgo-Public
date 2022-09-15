import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] m : clothes) {
            map.put(m[1], map.getOrDefault(m[1], 1) + 1);
        }

        for (int v : map.values()) {
            answer *= v;
        }
        return answer - 1;
    }
}