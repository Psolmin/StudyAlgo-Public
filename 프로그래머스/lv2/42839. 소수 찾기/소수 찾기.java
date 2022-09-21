import java.util.HashSet;
import java.util.Set;

class Solution {
    boolean[] prime;
    Set<Integer> answer = new HashSet<>();

    public int solution(String numbers) {
//        int answer = 0;

        prime = new boolean[(int) Math.pow(10, numbers.length())];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length - 1); i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
        findAllCase("", numbers);
        
        return answer.size();
    }

    private void findAllCase(String standard, String move) {
        if (standard.length() > 0) {
            int num = Integer.parseInt(standard);
            if (!prime[num]) {
                answer.add(num);
            }
        }

        for (int i = 0; i < move.length(); i++) {
            findAllCase(standard + move.charAt(i), move.substring(0, i) + move.substring(i + 1));
        }
    }
}