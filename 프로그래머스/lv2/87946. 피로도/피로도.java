import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<String> circuit = new HashSet<>();

    public int solution(int k, int[][] dungeons) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < dungeons.length; i++) {
            sb.append(i);
        }
        permutation("", sb.toString());

        int max = Integer.MIN_VALUE;
        for (String s : circuit) {
            int cur = k;
            int clear = 0;
            for (char c : s.toCharArray()) {
                int i = Character.getNumericValue(c);
                if (dungeons[i][0] > cur) {
                    break;
                }
                cur -= dungeons[i][1];
                clear++;
            }

            if (clear > max) {
                max = clear;
            }
        }

        return max;
    }

    private void permutation(String prefix, String str) {
        if (str.length() == 0) {
            circuit.add(prefix);
        }

        for (int i = 0; i < str.length(); i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
        }
    }
}