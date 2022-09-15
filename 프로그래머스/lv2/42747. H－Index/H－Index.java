import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 0 1 2 3 5 5 5 6

        int h = citations[citations.length / 2];
        while (true) {
            int[] ints = check(citations, h);

            int high = ints[0];
            int low = ints[1];
            if (h <= high && h >= low) {
                break;
            } else if (h > ints[0]) {
                h--;
                continue;
            } else if (h < ints[1]) {
                h++;
                continue;
            }
        }
        return h;
    }
    private int[] check(int[] citations, int h) {
        int high = 0;
        int low = 0;
        for (int i : citations) {
            if (i >= h) {
                high++;
            } else {
                low++;
            }
        }

        return new int[]{high, low};
    }
}