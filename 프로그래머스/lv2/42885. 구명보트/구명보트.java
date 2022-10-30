import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        // 정렬 후 큰 것 작은 것 비교
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