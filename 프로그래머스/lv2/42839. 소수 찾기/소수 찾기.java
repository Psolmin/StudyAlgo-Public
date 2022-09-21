import java.util.HashSet;
import java.util.Set;

class Solution {
//    boolean[] prime;
    Set<Integer> numSet = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

//        prime = new boolean[(int) Math.pow(10, numbers.length())];
//        prime[0] = prime[1] = true;
//        for (int i = 2; i <= Math.sqrt(prime.length - 1); i++) {
//            if (prime[i]) {
//                continue;
//            }
//
//            for (int j = i * i; j < prime.length; j += i) {
//                prime[j] = true;
//            }
//        }
        findAllCase("", numbers);
        for (Integer i : numSet) {
            if (i == 2) {
                answer++;
            }
            if (i % 2 != 0 && isPrime(i)) {
                answer++;
            }
        }

        return answer;
    }
    public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
    private void findAllCase(String standard, String move) {
        if (standard.length() > 0) {
            int n = Integer.parseInt(standard);
//            if (!prime[num]) {
//                answer.add(num);
//            }
            numSet.add(n);
        }

        for (int i = 0; i < move.length(); i++) {
            findAllCase(standard + move.charAt(i), move.substring(0, i) + move.substring(i + 1));
        }
    }
}