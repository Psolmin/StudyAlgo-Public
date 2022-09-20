import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        int count = 0;
        for (String str : operations) {
            String[] s = str.split(" ");
            String operation = s[0];
            int num = Integer.parseInt(s[1]);

            if (operation.equals("I")) {
                min.add(num);
                max.add(num);
                count++;
            } else if (operation.equals("D")) {
                if (num == 1) {
                    max.poll();
                } else if (num == -1) {
                    min.poll();
                }
                count--;
                if (count <= 0) {
                    count = 0;
                    max.clear();
                    min.clear();
                }
            }
        }

        return count > 0 ? new int[]{max.poll(), min.poll()} : new int[]{0, 0};
    }
}