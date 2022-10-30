import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] people, int limit) {
        // 내림차순으로 정렬, limit 비교하면서 삭제
        int answer = 0;
        
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            answer++;
            if (people[right--] + people[left] <= limit) {
                left++;
            }
        }

        return answer;
    }
}