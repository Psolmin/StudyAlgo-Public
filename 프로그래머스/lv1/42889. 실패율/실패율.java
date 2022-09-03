import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
List<Integer> answer = new ArrayList<>();

        Map<Integer, Integer> result = new HashMap<>();
        float total = stages.length;

        for (int stage : stages) {
            result.put(stage, result.getOrDefault(stage, 0) + 1);
        }

        Map<Integer, Float> rate = new HashMap<>();
        for (int i = 1; i <= N + 1 && total > 0; i++) {
            rate.put(i, result.getOrDefault(i, 0) / total);
            total -= result.getOrDefault(i, 0);
        }
        System.out.println("rate = " + rate);

        List<Map.Entry<Integer, Float>> entryList = new LinkedList<>(rate.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<Integer, Float> entry : entryList) {
            if (entry.getKey() == N + 1) {
                continue;
            }
            answer.add(entry.getKey());
        }
        
        for (int i = answer.size() + 1; i <= N; i++) {
            answer.add(i);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}