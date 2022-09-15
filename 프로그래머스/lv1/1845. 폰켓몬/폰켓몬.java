import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int max = nums.length / 2;
        return countMap.size() < max ? countMap.size() : max;
    }
}