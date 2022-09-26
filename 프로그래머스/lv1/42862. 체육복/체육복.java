import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] cloth = new int[n + 1];
        Arrays.fill(cloth, 1);
        
        for (int i : lost) {
            cloth[i]--;
        }
        for (int i : reserve) {
            cloth[i]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (cloth[i] == 0 && i > 1 && cloth[i - 1] == 2){
                cloth[i]++;
                cloth[i - 1]--;
            }
            if(cloth[i] == 0 && i < n && cloth[i + 1] == 2){
                cloth[i]++;
                cloth[i + 1]--;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (cloth[i] > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}