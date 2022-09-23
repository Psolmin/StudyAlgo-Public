class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int sum, int i) {
        if (i == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, target, sum + numbers[i], i + 1);
        dfs(numbers, target, sum - numbers[i], i + 1);
    }
}